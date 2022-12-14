package project.options;

import project.jobs.ViewDoctors;
import project.jobs.ViewAvailableAppointments;
import project.jobs.ViewAvailableAppointmentsBySpecialty;
import project.jobs.ScheduleAppointment;
import project.jobs.CancelAppointment;
import project.jobs.ViewDoctorAppointments;
import project.jobs.ViewOcupatesDoctorAppointments;
import project.jobs.AddAppointment;
import project.jobs.UpdateAppointment;
import project.jobs.RemoveAppointment;

public class Option {
    public Runnable Job;
    public String Name;
}

public class Options {
    private Option[] options;

    public static Options GetPatientOptions() {
        Options options = new Options();
        options.options = new Option[]{
            new Option(){
                Name = "Salir"
            },
            new Option(){
                Name = "Ver lista de doctores",
                Job = ViewDoctors::run
            },
            new Option(){
                Name = "Ver citas disponibles",
                Job = ViewAvailableAppointments::run
            },
            new Option(){
                Name = "Ver citas disponibles por especialidad",
                Job = ViewAvailableAppointmentsBySpecialty::run
            },
            new Option(){
                Name = "Agendar una cita",
                Job = ScheduleAppointment::run
            },
            new Option(){
                Name = "Cancelar una cita",
                Job = CancelAppointment::run
            }
        };
        return options;
    }

    public static Options GetDoctorOptions() {
        Options options = new Options();
        options.options = new Option[]{
            new Option(){
                Name = "Salir"
            },
            new Option(){
                Name = "Ver mis citas",
                Job = ViewDoctorAppointments::run
            },
            new Option(){
                Name = "Ver citas ocupadas",
                Job = ViewOcupatesDoctorAppointments::run
            },
            new Option(){
                Name = "Añadir una cita",
                Job = AddAppointment::run
            },
            new Option(){
                Name = "Reagendar una cita",
                Job = UpdateAppointment::run
            },
            new Option(){
                Name = "Eliminar una cita",
                Job = RemoveAppointment::run
            }
        };
        return options;
    }

    public void ViewOptions() {
        for (int i = 0; i < options.length; i++) {
            if (i == 0) {
                System.out.printf("%d. %s\n", i, options[i].Name);
            } else {
                System.out.printf("%d. %s\n", i, options[i].Name);
            }
        }
    }
}
