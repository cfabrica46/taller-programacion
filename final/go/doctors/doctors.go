package doctors

import (
	"encoding/json"
	"fmt"
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
	Password       string    `json:"password"`
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

func GetDoctors() (docs map[string]Doctor, err error) {
	var doctors []Doctor

	err = json.Unmarshal(dataDoctors, &doctors)
	if err != nil {
		return nil, err
	}

	docs = make(map[string]Doctor)

	for _, doc := range doctors {
		docs[doc.DNI] = doc
	}

	return docs, nil
}

func CheckCredentials(dni, password string) (acces bool) {
	doctors, err := GetDoctors()
	if err != nil {
		log.Fatal(err)
	}

	for i := range doctors {
		if dni == doctors[i].DNI && password == doctors[i].Password {
			return true
		}
	}

	return false
}

func GetSpecialties() (specialties []Specialty) {
	return append(specialties, dermatologist, neurologist, pediatrician, psychiatrist)
}

func ViewSpecialties(specialties []Specialty) {
	for i := range specialties {
		fmt.Printf("%d. %s\n", i+1, specialties[i])
	}
}

func UpdateData(docs map[string]Doctor) {
	var doctors []Doctor

	for i := range docs {
		doctors = append(doctors, docs[i])
	}

	data, err := json.MarshalIndent(doctors, "", "    ")
	if err != nil {
		log.Fatal(err)
	}

	if err := os.WriteFile("doctors.json", data, 0o644); err != nil {
		log.Fatal(err)
	}
}
