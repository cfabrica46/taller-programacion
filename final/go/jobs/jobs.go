package jobs

import (
	"fmt"
	"log"

	"project/appointments"
	"project/doctors"
)

func ViewDoctors() {
	var counter int

	docs, err := doctors.GetDoctors()
	if err != nil {
		log.Fatal(err)
	}

	for i := range docs {
		appoints, err := appointments.GetNumberFreeAppointmentsByDoctorDNI(i)
		if err != nil {
			log.Fatal(err)
		}

		fmt.Printf(
			"%d. Dr(a).%s - %s - Age: %d - Citas Disponibles: %d\n",
			counter+1,
			docs[i].Name,
			docs[i].Specialty,
			docs[i].Age,
			appoints,
		)

		counter++
	}
}

func ViewAvailableAppointments() {
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
		fmt.Printf(
			"%d. Dr(a).%s - %s - Fecha: %s\n",
			counter+1,
			docs[appoints[i].DoctorDNI].Name,
			docs[appoints[i].DoctorDNI].Specialty,
			appoints[i].StartTime,
		)

		counter++
	}
}

func ViewAvailableAppointmentsBySpecialty() {
	var option, counter int

	speciaties := doctors.GetSpecialties()

	fmt.Println("Que especialidad necesita?")
	doctors.ViewSpecialties(speciaties)
	fmt.Print("> ")
	fmt.Scan(&option)
	fmt.Println()

	if option <= 0 || option > len(speciaties) {
		log.Fatal("Opcion invalida")
	}

	// ---

	docs, err := doctors.GetDoctors()
	if err != nil {
		log.Fatal(err)
	}

	appoints, err := appointments.GetAppointments()
	if err != nil {
		log.Fatal(err)
	}

	for i := range appoints {
		if docs[appoints[i].DoctorDNI].Specialty == speciaties[option-1] {

			fmt.Printf(
				"%d. Dr(a).%s - %s - Fecha: %s\n",
				counter+1,
				docs[appoints[i].DoctorDNI].Name,
				docs[appoints[i].DoctorDNI].Specialty,
				appoints[i].StartTime,
			)

			counter++
		}
	}
}

func ScheduleAppointment() {
	var id string

	appoints, err := appointments.GetAppointments()
	if err != nil {
		log.Fatal(err)
	}

	fmt.Println("Ingrese el ID de la cita que desea agendar")
	fmt.Print("> ")
	fmt.Scan(&id)
	fmt.Println()

	if !appoints[id].Free {
		log.Fatal("La cita ya fue agendada")
	}

	newAppointment := appoints[id]

	newAppointment.Free = false

	appoints[id] = newAppointment

	appointments.UpdateData(appoints)

	fmt.Println("Cita Agendada Correctamente!")
}

func CancelAppointment() {
	var id string

	appoints, err := appointments.GetAppointments()
	if err != nil {
		log.Fatal(err)
	}

	fmt.Println("Ingrese el ID de la cita que desea cancelar")
	fmt.Print("> ")
	fmt.Scan(&id)
	fmt.Println()

	if appoints[id].Free {
		log.Fatal("Esta cita no esta ocupada")
	}

	newAppointment := appoints[id]

	newAppointment.Free = true

	appoints[id] = newAppointment

	appointments.UpdateData(appoints)

	fmt.Println("Cita Cancelada Correctamente!")
}
