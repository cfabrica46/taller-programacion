package jobs

import (
	"fmt"

	"go/doctors"
)

func ViewDoctors() {
	fmt.Println("View Doctors")
	doctors.NewDoctor()
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
