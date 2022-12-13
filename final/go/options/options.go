package options

import (
	"fmt"

	"project/jobs"
)

type Option struct {
	Job  func()
	Name string
}

type Options []Option

func GetPatientOptions() Options {
	return Options{
		{
			Name: "Salir",
		},
		{
			Name: "Ver lista de doctores",
			Job:  jobs.ViewDoctors,
		},
		{
			Name: "Ver citas disponibles",
			Job:  jobs.ViewAvailableAppointments,
		},
		{
			Name: "Ver citas disponibles por especialidad",
			Job:  jobs.ViewAvailableAppointmentsBySpecialty,
		},
		{
			Name: "Agendar una cita",
			Job:  jobs.ScheduleAppointment,
		},
		{
			Name: "Cancelar una cita",
			Job:  jobs.CancelAppointment,
		},
	}
}

func GetDoctorOptions() Options {
	return Options{
		{
			Name: "Salir",
		},
		{
			Name: "Ver mis citas",
			Job:  jobs.ViewDoctorAppointments,
		},
		{
			Name: "Ver citas ocupadas",
			Job:  jobs.ViewOcupatesDoctorAppointments,
		},
		{
			Name: "Añadir una cita",
			Job:  jobs.AddAppointment,
		},
		{
			Name: "Reagendar una cita",
		},
		{
			Name: "Eliminar una cita",
		},
	}
}

func (o Options) ViewOptions() {
	for i := range o {
		if i == 0 {
			defer fmt.Printf("%d. %s\n", i, o[i].Name)
		} else {
			fmt.Printf("%d. %s\n", i, o[i].Name)
		}
	}
}
