package options

import (
	"fmt"

	"go/jobs"
)

type Option struct {
	Job  func()
	Name string
}

func GetOptions() Options {
	return Options{
		{
			Name: "Salir",
		},
		{
			Name: "Ver lista de doctores",
			Job:  jobs.ViewDoctors,
		},
		{
			Name: "Agendar una cita",
			Job:  jobs.ScheduleAppointment,
		},
		{
			Name: "Reprogramar una cita",
			Job:  jobs.RescheduleAppointment,
		},
		{
			Name: "Cancelar una cita",
			Job:  jobs.CancelAppointment,
		},
	}
}

type Options []Option

func (o Options) ViewOptions() {
	for i := range o {
		if i == 0 {
			defer fmt.Printf("%d. %s\n", i, o[i].Name)
		} else {
			fmt.Printf("%d. %s\n", i, o[i].Name)
		}
	}
}
