package doctors

import (
	"encoding/json"
	"log"
	"os"
)

type Specialty string

const (
	dermatologist Specialty = "Dermatologo"
	neurologist   Specialty = "Neurologo"
	psychiatrist  Specialty = "Psiquiatra"
	pediatrician  Specialty = "Pediatra"
)

type Doctor struct {
	DNI            string    `json:"dni"`
	Name           string    `json:"name"`
	Age            int       `json:"age"`
	Specialty      Specialty `json:"specialty"`
	AppointmentsID []string  `json:"appointmentsID"`
}

var dataDoctors []byte

func init() {
	var err error

	dataDoctors, err = os.ReadFile("doctors.json")
	if err != nil {
		log.Fatal(err)
	}
}

func GetDoctors() (doctors []Doctor, err error) {
	err = json.Unmarshal(dataDoctors, &doctors)
	if err != nil {
		return nil, err
	}

	return doctors, nil
}
