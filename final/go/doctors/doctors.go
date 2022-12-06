package doctors

import (
	"encoding/json"
	"fmt"
	"log"
	"time"
)

type Specialty string

const (
	dermatologist Specialty = "Dermatologo"
	neurologist   Specialty = "Neurologo"
	psychiatrist  Specialty = "Psiquiatra"
	pediatrician  Specialty = "Pediatra"
)

type DayOfWeek string

const (
	Monday    DayOfWeek = "lunes"
	Tuesday   DayOfWeek = "martes"
	Wednesday DayOfWeek = "miercoles"
	Thursday  DayOfWeek = "jueves"
	Friday    DayOfWeek = "viernes"
	Saturday  DayOfWeek = "sabado"
	Sunday    DayOfWeek = "domingo"
)

type Appointment struct {
	// DayOfWeek DayOfWeek
	ID        string `json:"id"`
	StartTime string `json:"startTime"`
	EndTime   string `json:"endTime"`
	Duration  int    `json:"duration"`
	Free      bool   `json:"free"`
	patienDNI string `json:"patienDNI,omitempty"`
}

type Doctor struct {
	Name         string        `json:"name"`
	Age          int           `json:"age"`
	Specialty    Specialty     `json:"specialty"`
	Appointments []Appointment `json:"appointments"`
}

func NewDoctor() {
	t := time.Now()

	newTime := time.Date(
		t.Year(),
		t.Month(),
		t.Day(),
		20,
		0,
		0,
		0,
		time.UTC,
	)
	endTime := newTime.Add(time.Minute * 30)

	d := []Doctor{{
		Name:      "Carlos",
		Age:       30,
		Specialty: dermatologist,
		Appointments: []Appointment{
			{
				ID:        "",
				Free:      true,
				StartTime: newTime.Format(time.RFC822),
				EndTime:   endTime.Format(time.RFC822),
				Duration:  int(endTime.Sub(newTime).Minutes()),
			},
		},
	}}

	data, err := json.MarshalIndent(d, "", " ")
	if err != nil {
		log.Fatal(err)
	}

	fmt.Printf("%s\n", data)

	/* err = os.WriteFile("doctors.json", data, 0o644)
	if err != nil {
		log.Fatal(err)
	} */
}
