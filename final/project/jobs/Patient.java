package project.jobs;

import java.util.logging.Level;
import java.util.logging.Logger;
import project.appointments.Appointments;
import project.doctors.Doctors;

public class Patient {
    
    public static void viewDoctors(){
        int counter = 0;
        
        Doctors docs = null;
        try {
            docs = Doctors.getDoctors();
        } catch (Exception ex) {
            Logger.getLogger(Jobs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < docs.length; i++) {            
            int appoints = 0;
            try {
                appoints = Appointments.getNumberFreeAppointmentsByDoctorDNI(i);
            } catch (Exception ex) {
                Logger.getLogger(Jobs.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.printf("%d. Dr(a).%s - %s - Age: %d - Citas Disponibles: %d\n", counter+1, docs[i].getName(), docs[i].getSpecialty(), docs[i].getAge(), appoints);
            counter++;
        }
    }
    
    public static void viewAvailableAppointments(){
        int counter = 0;
        
        Doctors docs = null;
        try {
            docs = Doctors.getDoctors();
        } catch (Exception ex) {
            Logger.getLogger(Jobs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Appointments[] appoints = null;
        try {
            appoints = Appointments.getAppointments();
        } catch (Exception ex) {
            Logger.getLogger(Jobs.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < appoints.length; i++) {            
            System.out.printf("%d. Dr(a).%s - %s - Fecha: %s\n", counter+1, docs[appoints[i].getDoctorDNI()].getName(), docs[appoints[i].getDoctorDNI()].getSpecialty(), appoints[i].getStartTime());
            counter++;
        }
    }

	public static void viewAvailableAppointmentsBySpecialty() {
		int option, counter = 0;
		
		String[] speciaties = Doctors.getSpecialties();
		
		System.out.println("Que especialidad necesita?");
		Doctors.viewSpecialties(speciaties);
		System.out.print("> ");
		
		Scanner scanner = new Scanner(System.in);
		option = scanner.nextInt();
		System.out.println();
		
		if (option <= 0 || option > speciaties.length) {
			System.err.println("Opcion invalida");
			System.exit(1);
		}
		
		// ---
		
		String[][] docs;
		
		try {
			docs = Doctors.getDoctors();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		String[][] appoints;
		
		try {
			appoints = Appointments.getAppointments();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		for (String[] appoint : appoints) {
			if (docs[Integer.parseInt(appoint[2])][2].equals(speciaties[option - 1])) {
				System.out.printf("%d. Dr(a).%s - %s - Fecha: %s\n", counter + 1, docs[Integer.parseInt(appoint[2])][1], docs[Integer.parseInt(appoint[2])][2], appoint[3]);
				counter++;
			}
		}
	}
	
	public static void scheduleAppointment(){
        String id;
        
        Appointments appoints;
        try {
            appoints = Appointments.getAppointments();

            System.out.println("Ingrese el ID de la cita que desea agendar");
            System.out.print("> ");
            Scanner sc = new Scanner(System.in);
            id = sc.nextLine();
            System.out.println();

            if(!appoints.getAppointment(id).isFree()){
                Logger.getLogger(ScheduleAppointment.class.getName()).log(Level.SEVERE, null, new Exception("La cita ya fue agendada"));
            }

            appoints.getAppointment(id).setFree(false);
            appoints.updateData(appoints);

            System.out.println("Cita Agendada Correctamente!");
        } catch (Exception ex) {
            Logger.getLogger(ScheduleAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	 public static void cancelAppointment(){
        String id;
        
        Appointments appoints;
        try {
            appoints = Appointments.getAppointments();

            System.out.println("Ingrese el ID de la cita que desea cancelar");
            System.out.print("> ");
            Scanner sc = new Scanner(System.in);
            id = sc.nextLine();
            System.out.println();

            if(appoints.getAppointment(id).isFree()){
                Logger.getLogger(ScheduleAppointment.class.getName()).log(Level.SEVERE, null, new Exception("Esta cita no esta ocupada"));
            }

            appoints.getAppointment(id).setFree(true);
            appoints.updateData(appoints);

            System.out.println("Cita Cancelada Correctamente!");
        } catch (Exception ex) {
            Logger.getLogger(ScheduleAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
