package appointments

import (
	"encoding/json"
	"log"
	"os"
)

type Appointment struct {
	DoctorDNI string `json:"doctorDNI"`
	ID        string `json:"id"`
	StartTime string `json:"startTime"`
	EndTime   string `json:"endTime"`
	Duration  int    `json:"duration"`
	Free      bool   `json:"free"`
	patienDNI string `json:"patienDNI,omitempty"`
}

var dataAppointments []byte

func init() {
	var err error

	dataAppointments, err = os.ReadFile("appointments.json")
	if err != nil {
		log.Fatal(err)
	}
}

func GetAppointments() (appointments []Appointment, err error) {
	err = json.Unmarshal(dataAppointments, &appointments)
	if err != nil {
		return nil, err
	}

	return appointments, nil
}

func GetNumberFreeAppointmentsByDoctorDNI(dni string) (numberAppointments int, err error) {
	appointments, err := GetAppointments()
	if err != nil {
		return 0, err
	}

	for i := range appointments {
		if appointments[i].DoctorDNI == dni && appointments[i].Free {
			numberAppointments++
		}
	}

	return numberAppointments, nil
}
