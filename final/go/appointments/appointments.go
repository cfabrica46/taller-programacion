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

func GetAppointments() (appoints map[string]Appointment, err error) {
	var appointments []Appointment

	err = json.Unmarshal(dataAppointments, &appointments)
	if err != nil {
		return nil, err
	}

	appoints = make(map[string]Appointment)

	for _, appoint := range appointments {
		appoints[appoint.ID] = appoint
	}

	return appoints, nil
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

func UpdateData(appoints map[string]Appointment) {
	var appointments []Appointment

	for i := range appoints {
		appointments = append(appointments, appoints[i])
	}

	data, err := json.MarshalIndent(appointments, "", "    ")
	if err != nil {
		log.Fatal(err)
	}

	if err := os.WriteFile("appointments.json", data, 0o644); err != nil {
		log.Fatal(err)
	}
}
