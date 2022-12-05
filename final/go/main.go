package main

import (
	"fmt"
	"go/options"
)

func main() {
	var optionSelected int
	var availableOption bool

	myOptions := options.GetOptions()

	fmt.Println("Bienvenido a la clinica `cfabrica46`")

	for !availableOption {
		fmt.Printf("\nQue desea hacer?\n")
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

	fmt.Println("\nUsted escogio:", myOptions[optionSelected].Name)
}
