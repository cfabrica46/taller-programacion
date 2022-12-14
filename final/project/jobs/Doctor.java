package project.jobs;

import java.util.UUID;
import java.util.logging.Logger;
import project.appointments.Appointments;
import project.doctors.Doctors;

public class Doctor {
	private static String doctorDNI;
	public static void setDoctorDNI(String dni) {
		doctorDNI = dni;
	}

	public static void viewDoctorAppointments() {
		int counter = 0;
		try {
			Doctors docs = Doctors.getDoctors();
			Appointments appoints = Appointments.getAppointments();
			for (int i = 0; i < appoints.length; i++) {
				if (appoints[i].getDoctorDNI() == doctorDNI) {
					String doctorName = docs.getName(doctorDNI);
					String doctorSpecialty = docs.getSpecialty(doctorDNI);
					String startTime = appoints[i].getStartTime();
					boolean isFree = appoints[i].isFree();
					System.out.printf("%d. Dr(a).%s - %s - Fecha: %s - Free: %b \n",
						counter + 1, doctorName, doctorSpecialty, startTime, isFree);
					counter++;
				}
			}
		} catch (Exception e) {
			Logger.getGlobal().log(e.getMessage());
		}
	}

	public static void viewOcupatedDoctorAppointments() {
		int counter = 0;
		try {
			Doctors docs = Doctors.getDoctors();
			Appointments appoints = Appointments.getAppointments();
			for (int i = 0; i < appoints.length; i++) {
				if (appoints[i].getDoctorDNI() == doctorDNI) {
					if (!appoints[i].isFree()) {
						String doctorName = docs.getName(doctorDNI);
						String doctorSpecialty = docs.getSpecialty(doctorDNI);
						String startTime = appoints[i].getStartTime();
						System.out.printf("%d. Dr(a).%s - %s - Fecha: %s \n", counter + 1, doctorName, doctorSpecialty,
							startTime);
						counter++;
					}
				}
			}
		} catch (Exception e) {
			Logger.getGlobal().log(e.getMessage());
		}
	}

	    public static void addAppointment(){
        Scanner sc = new Scanner(System.in);
        int year, month, day, hour, min, durationMin;

        System.out.println("Ingrese los datos de la reunion que desea agregar");
        System.out.print("Año: ");
        year = sc.nextInt();
        System.out.print("Mes: ");
        month = sc.nextInt();
        System.out.print("Dia: ");
        day = sc.nextInt();
        System.out.print("Hora: ");
        hour = sc.nextInt();
        System.out.print("Minuto: ");
        min = sc.nextInt();

        LocalDateTime startTime = LocalDateTime.of(year,month,day,hour,min);
        
        System.out.print("Ingrese cuanto tiempo durara la cita en minutos: ");
        durationMin = sc.nextInt();

        LocalDateTime endTime = startTime.plusMinutes(durationMin);

        String newID = UUID.randomUUID().toString();

        Appointments.appointments.put(newID, new Appointments(doctorDNI, newID, startTime, endTime, durationMin, true));
        Appointments.updateData(Appointments.appointments);

        Doctors doctor = Doctors.doctors.get(doctorDNI);
        ArrayList<String> appointmentsId = doctor.getAppointmentsId();
        appointmentsId.add(newID);
        doctor.setAppointmentsId(appointmentsId);

        Doctors.doctors.put(doctorDNI, doctor);
        Doctors.updateData(Doctors.doctors);
        System.out.println("Cita creada con exito!");
    }

	public static void updateAppointment() {

		String id = "";
		int year = 0;
		int month = 0;
		int day = 0;
		int hour = 0;
		int min = 0;
		int durationMin = 0;

		System.out.println("Ingrese el id de la cita que desea actualizar");
		System.out.print("> ");
		Scanner scanner = new Scanner(System.in);
		id = scanner.nextLine();
		System.out.println();

		Appointments appoints = Appointments.getAppointments();

		if (appoints.get(id) == null) {
			logger.fatal("No existe el id de la cita");
		}

		System.out.println("Ingrese los nuevos datos de la cita");
		System.out.print("Año: ");
		year = scanner.nextInt();
		System.out.print("Mes: ");
		month = scanner.nextInt();
		System.out.print("Dia: ");
		day = scanner.nextInt();
		System.out.print("Hora: ");
		hour = scanner.nextInt();
		System.out.print("Minuto: ");
		min = scanner.nextInt();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date startTime = new Date();
		try {
			startTime = sdf.parse(year + month + day + hour +min);
		} catch (ParseException e) {
			logger.fatal(e);
		}
		
		System.out.print("Ingrese cuanto tiempo durara la cita en minutos: ");
		durationMin = scanner.nextInt();
		
		Date endTime = new Date(startTime.getTime()+durationMin*60000);

		Appointments newAppointment = new appointments.Appointment(doctorDNI,
																   UUID.randomUUID(),
																   startTime,
																   endTime,
																   durationMin,
																   true);

		appoints.put(id, newAppointment);
		appointments.updateData(appoints);

		System.out.println("Cita actualizada con exito!");
	}

	public static void removeAppointment() {
		Scanner scanner = new Scanner(System.in);
		String id;
		
		System.out.println("Ingrese el id de la cita que desea actualizar");
		System.out.print("> ");
		id = scanner.nextLine();
		System.out.println();
		
		Appointments appoints;
		try {
			appoints = Appointments.getAppointments();
		} catch (Exception err) {
			err.printStackTrace();
			return;
		}
		
		Doctors docs;
        try {
			docs = Doctors.getDoctors();
        } catch (Exception err) {
			err.printStackTrace();
			return;
		}
        
        Appointments.Appointments appointmentNil = new Appointments.Appointments();
		
		if (appoints.get(id).equals(appointmentNil)) {
			System.out.println("No existe el id de la cita");
		}
		
		appoints.remove(id);
		
		Doctors.Doctors doctor = docs.get(doctorDNI);
		
		for (int i = 0; i < doctor.appointmentsID.size(); i++) {
			if (doctor.appointmentsID.get(i).equals(id)) {
				doctor.appointmentsID.remove(i + 1);
			}
		}
		docs.put(doctorDNI, doctor);
		
		try {
			Appointments.updateData(appoints);
			Doctors.updateData(docs);
		} catch (Exception err) {
			err.printStackTrace();
			return;
		}
		
		System.out.println("Cita eliminada con éxito!");
	}
}
