package project.main;

import java.util.Scanner;

import project.doctors.CheckCredentials;
import project.jobs.SetDoctorDNI;
import project.options.GetDoctorOptions;
import project.options.GetPatientOptions;
import project.options.Options;

public class Programa {
    public static void main(String[] args) {
        int optionSelected;
        boolean availableOption;
        String typeLogin;
        Options myOptions;

        System.out.println("Bienvenido a la clinica `cfabrica46`\n\n");

        System.out.println("Quiere ingresar como paciente o doctor? [P/D]");
        System.out.print("> ");

        Scanner scanner = new Scanner(System.in);
        typeLogin = scanner.nextLine();
        System.out.println();

        typeLogin = typeLogin.toUpperCase();

        if (!typeLogin.equals("P") && !typeLogin.equals("D")) {
            System.out.println("Ingrese una opcion valida");
            return;
        }

        if (typeLogin.equals("D")) {
            String dni, password;

            System.out.println("Ingrese su DNI");
            System.out.print("> ");

            dni = scanner.nextLine();
            System.out.println();

            System.out.println("Ingrese su contraseña");
            System.out.print("> ");

            password = scanner.nextLine();
            System.out.println();

            boolean acces = CheckCredentials.checkCredentials(dni, password);
            if (!acces) {
                System.out.println("Credenciales incorrectas");
                return;
            }

            SetDoctorDNI.setDoctorDNI(dni);
        }

        if (typeLogin.equals("D")) {
            System.out.println("Bienvenido Doctor! Que desea hacer?");
            myOptions = GetDoctorOptions.getDoctorOptions();
        } else {
            System.out.println("Bienvenido Paciente! Que desea hacer?");
            myOptions = GetPatientOptions.getPatientOptions();
        }

        availableOption = false;

        while (!availableOption) {
            for (int i = 0; i < myOptions.length; i++) {
                System.out.print(myOptions[i].getName() + "\n");
            }

            System.out.print("> ");
            optionSelected = scanner.nextInt();

            if (optionSelected >= 0 && optionSelected < myOptions.length) {
                if (optionSelected == 0) {
                    System.out.print("Muchas Gracias :D\n");
                     return;
                }

                availableOption = true;
            } else {
                System.out.print("\nElija una opcion valida\n");
            }
        }

        System.out.print("\nUsted escogio: " + myOptions[optionSelected].getName() + "\n\n");
        myOptions[optionSelected].job();
    }
}
