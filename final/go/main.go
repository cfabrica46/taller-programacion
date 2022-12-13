package main

import (
	"fmt"
	"log"
	"strings"

	"project/doctors"
	"project/jobs"
	"project/options"
)

func main() {
	var optionSelected int
	var availableOption bool
	var typeLogin string
	var myOptions options.Options

	fmt.Printf("Bienvenido a la clinica `cfabrica46`\n\n")

	fmt.Println("Quiere ingresar como paciente o doctor? [P/D]")
	fmt.Print("> ")
	fmt.Scan(&typeLogin)
	fmt.Println()

	typeLogin = strings.ToUpper(typeLogin)

	if typeLogin != "P" && typeLogin != "D" {
		log.Fatal("Ingrese una opcion valida")
	}

	if typeLogin == "D" {
		var dni, password string

		fmt.Println("Ingrese su DNI")
		fmt.Print("> ")
		fmt.Scan(&dni)
		fmt.Println()

		fmt.Println("Ingrese su contraseña")
		fmt.Print("> ")
		fmt.Scan(&password)
		fmt.Println()

		acces := doctors.CheckCredentials(dni, password)
		if !acces {
			log.Fatal("Credenciales incorrectas")
		}

		jobs.SetDoctorDNI(dni)
	}

	if typeLogin == "D" {
		fmt.Println("Bienvenido Doctor! Que desea hacer?")
		myOptions = options.GetDoctorOptions()
	} else {
		fmt.Println("Bienvenido Paciente! Que desea hacer?")
		myOptions = options.GetPatientOptions()
	}

	for !availableOption {
		myOptions.ViewOptions()

		fmt.Print("> ")
		fmt.Scan(&optionSelected)

		if optionSelected >= 0 && optionSelected < len(myOptions) {
			if optionSelected == 0 {
				fmt.Println("Muchas Gracias :D")
				return
			}

			availableOption = true
		} else {
			fmt.Printf("\nElija una opcion valida\n")
		}
	}

	fmt.Printf("\nUsted escogio: %s \n\n", myOptions[optionSelected].Name)

	myOptions[optionSelected].Job()
}
