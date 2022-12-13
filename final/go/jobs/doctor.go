package jobs

import (
	"fmt"
	"log"

	"project/appointments"
	"project/doctors"
)

var doctorDNI string

func SetDoctorDNI(dni string) {
	doctorDNI = dni
}

func ViewDoctorAppointments() {
	var counter int

	docs, err := doctors.GetDoctors()
	if err != nil {
		log.Fatal(err)
	}

	appoints, err := appointments.GetAppointments()
	if err != nil {
		log.Fatal(err)
	}

	for i := range appoints {
		if appoints[i].DoctorDNI == doctorDNI {
			fmt.Printf(
				"%d. Dr(a).%s - %s - Fecha: %s - Free: %v\n",
				counter+1,
				docs[doctorDNI].Name,
				docs[doctorDNI].Specialty,
				appoints[i].StartTime,
				appoints[i].Free,
			)
			counter++
		}
	}
}

func ViewOcupatesDoctorAppointments() {
	var counter int

	docs, err := doctors.GetDoctors()
	if err != nil {
		log.Fatal(err)
	}

	appoints, err := appointments.GetAppointments()
	if err != nil {
		log.Fatal(err)
	}

	for i := range appoints {
		if appoints[i].DoctorDNI == doctorDNI {
			if !appoints[i].Free {
				fmt.Printf(
					"%d. Dr(a).%s - %s - Fecha: %s\n",
					counter+1,
					docs[doctorDNI].Name,
					docs[doctorDNI].Specialty,
					appoints[i].StartTime,
				)
				counter++
			}
		}
	}
}
