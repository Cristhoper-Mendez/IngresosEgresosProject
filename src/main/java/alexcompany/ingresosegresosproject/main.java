package alexcompany.ingresosegresosproject;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        int opcion;
         Mantenimiento mantenimiento = new Mantenimiento();
        Scanner scn = new Scanner(System.in);
        do {
            System.out.println("Ingrese el numero de opcion que desee usar:");
            System.out.println("1- Agregar catalogo de conceptos.");
            System.out.println("2- Agregar categoria.");
            System.out.println("3- Agregar ingreso.");
            System.out.println("4- Agregar egreso.");
            System.out.println("5- Ver resumen");
            System.out.println("6- Salir.");

            opcion = scn.nextInt();

            if (opcion == 6) {
                break;
            }
            EjecutarAccion(opcion,  mantenimiento);
        } while (opcion != 6);
    }

    public static void EjecutarAccion(int accion, Mantenimiento mantenimiento) {

       
        switch (accion) {
            case 1:
                mantenimiento.AgregarConcepto();

                break;
            case 2:
                mantenimiento.AgregarCategoria();
                break;
            case 3:
                mantenimiento.AgregarIngreso();
                break;
            case 4:
                mantenimiento.AgregarEgreso();
                break;
            case 5:
                mantenimiento.VerResumen();
                break;
            default:
                System.out.println("Opcion no valida intentalo de nuevo.");
                break;
        }
    }
}
