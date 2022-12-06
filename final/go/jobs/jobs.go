package jobs

import (
	"fmt"
	"log"

	"go/appointments"
	"go/doctors"
)

func ViewDoctors() {
	docs, err := doctors.GetDoctors()
	if err != nil {
		log.Fatal(err)
	}

	for i := range docs {
		appoints, err := appointments.GetNumberFreeAppointmentsByDoctorDNI(docs[i].DNI)
		if err != nil {
			log.Fatal(err)
		}

		fmt.Printf(
			"%d. Dr(a).%s - %s - Age: %d - Citas Disponibles: %d\n",
			i+1,
			docs[i].Name,
			docs[i].Specialty,
			docs[i].Age,
			appoints,
		)
	}
}

func ScheduleAppointment() {
	fmt.Println("Schedule Appointment")
}

func RescheduleAppointment() {
	fmt.Println("Reschedule Appointment")
}

func CancelAppointment() {
	fmt.Println("Cancel Appointment")
}
