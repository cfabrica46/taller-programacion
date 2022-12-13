package jobs

import (
	"fmt"
	"log"
	"time"

	"project/appointments"
	"project/doctors"

	"github.com/google/uuid"
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

func AddAppointment() {
	var year, month, day, hour, min, durationMin int

	fmt.Println("Ingrese los datos de la reunion que desea agregar")
	fmt.Print("Año: ")
	fmt.Scan(&year)
	fmt.Print("Mes: ")
	fmt.Scan(&month)
	fmt.Print("Dia: ")
	fmt.Scan(&day)
	fmt.Print("Hora: ")
	fmt.Scan(&hour)
	fmt.Print("Minuto: ")
	fmt.Scan(&min)

	startTime := time.Date(year, time.Month(month), day, hour, min, 0, 0, time.UTC)

	fmt.Print("Ingrese cuanto tiempo durara la cita en minutos: ")
	fmt.Scan(&durationMin)

	endTime := startTime.Add(time.Minute * time.Duration(durationMin))

	newID := uuid.NewString()

	newAppointment := appointments.Appointment{
		DoctorDNI: doctorDNI,
		ID:        newID,
		StartTime: startTime.Format(time.RFC822),
		EndTime:   endTime.Format(time.RFC822),
		Duration:  durationMin,
		Free:      true,
	}

	appoints, err := appointments.GetAppointments()
	if err != nil {
		log.Fatal(err)
	}

	appoints[newID] = newAppointment
	appointments.UpdateData(appoints)

	docs, err := doctors.GetDoctors()
	if err != nil {
		log.Fatal(err)
	}

	doctor := docs[doctorDNI]
	doctor.AppointmentsID = append(doctor.AppointmentsID, newID)

	docs[doctorDNI] = doctor
	doctors.UpdateData(docs)

	fmt.Println("Cita creada con exito!")
}

func UpdateAppointment() {
	var id string
	var year, month, day, hour, min, durationMin int

	fmt.Println("Ingrese el id de la cita que desea actualizar")
	fmt.Print("> ")
	fmt.Scan(&id)
	fmt.Println()

	appoints, err := appointments.GetAppointments()
	if err != nil {
		log.Fatal(err)
	}

	appointmentNil := appointments.Appointment{}

	if appoints[id] == appointmentNil {
		log.Fatal("No existe el id de la cita")
	}

	fmt.Println("Ingrese los nuevos datos de la cita")
	fmt.Print("Año: ")
	fmt.Scan(&year)
	fmt.Print("Mes: ")
	fmt.Scan(&month)
	fmt.Print("Dia: ")
	fmt.Scan(&day)
	fmt.Print("Hora: ")
	fmt.Scan(&hour)
	fmt.Print("Minuto: ")
	fmt.Scan(&min)

	startTime := time.Date(year, time.Month(month), day, hour, min, 0, 0, time.UTC)

	fmt.Print("Ingrese cuanto tiempo durara la cita en minutos: ")
	fmt.Scan(&durationMin)

	endTime := startTime.Add(time.Minute * time.Duration(durationMin))

	newAppointment := appointments.Appointment{
		DoctorDNI: doctorDNI,
		ID:        id,
		StartTime: startTime.Format(time.RFC822),
		EndTime:   endTime.Format(time.RFC822),
		Duration:  durationMin,
		Free:      true,
	}

	appoints[id] = newAppointment
	appointments.UpdateData(appoints)

	fmt.Println("Cita actualizada con exito!")
}

func RemoveAppointment() {
	var id string

	fmt.Println("Ingrese el id de la cita que desea actualizar")
	fmt.Print("> ")
	fmt.Scan(&id)
	fmt.Println()

	appoints, err := appointments.GetAppointments()
	if err != nil {
		log.Fatal(err)
	}

	docs, err := doctors.GetDoctors()
	if err != nil {
		log.Fatal(err)
	}

	appointmentNil := appointments.Appointment{}

	if appoints[id] == appointmentNil {
		log.Fatal("No existe el id de la cita")
	}

	delete(appoints, id)

	doctor := docs[doctorDNI]

	for i := range doctor.AppointmentsID {
		if doctor.AppointmentsID[i] == id {
			doctor.AppointmentsID = append(doctor.AppointmentsID[:i], doctor.AppointmentsID[i+1:]...)
		}
	}
	docs[doctorDNI] = doctor

	appointments.UpdateData(appoints)
	doctors.UpdateData(docs)

	fmt.Println("Cita eliminada con exito!")
}
