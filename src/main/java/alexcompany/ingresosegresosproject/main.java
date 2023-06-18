package alexcompany.ingresosegresosproject;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        boolean salir = false;

        while (salir) {
            System.out.println("Ingrese el numero de opcion que desee usar:");
            System.out.println("1- Agregar catalogo de conceptos.");
            System.out.println("2- Agregar categoria.");
            System.out.println("3- Agregar ingreso.");
            System.out.println("4- Agregar egreso.");
            System.out.println("5- Ver resumen");
            System.out.println("6- Salir.");
            
            int opcion = scn.nextInt();
            
            if(opcion == 6){
                salir = true;
                return;
            }
        }
    }
    
    public void EjecutarAccion(int accion){
        switch(accion){
            case 1:
                break;
            default:
                System.out.println("Opcion no valida intentalo de nuevo.");
                break;
        }
    }
}
