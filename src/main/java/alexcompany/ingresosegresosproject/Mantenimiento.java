package alexcompany.ingresosegresosproject;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import Entidades.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Mantenimiento {

    private Scanner scn;
    private List<Concepto> LstConceptos = new ArrayList();
    private List<Categoria> LstCategorias = new ArrayList<>();
    private List<Ingreso> LstIngreso = new ArrayList<>();
    private List<Egreso> LstEgreso = new ArrayList<>();
    private int counter = 0;
    private float saldo = 0.0f;

    public Mantenimiento(Scanner scn) {
        this.scn = scn;
    }

    public void AgregarConcepto() {
        Concepto concpto = new Concepto();

        System.out.println("Ingrese el nombre de concepto.");
        concpto.setNombre(scn.next());
        System.out.println("Ingrese 1 si es Ingreso, ingrese 2 si es egreso");
        concpto.setTipo(scn.nextInt());

        System.out.println("Ingrese el id de categoria correspondiente.");
        for (Categoria cat : LstCategorias) {
            System.out.println("Id Categoria: " + cat.getCategoriaId() + " Nombre: " + cat.getNombre());
        }
        int categoriaId = scn.nextInt();
        concpto.setCategoriaId(categoriaId);

        concpto.setConceptoId(counter);

        counter++;

        LstConceptos.add(concpto);
    }

    public void AgregarCategoria() {
        Categoria newCategoria = new Categoria();
        System.out.println("Ingrese el nombre de la categoria.");
        newCategoria.setNombre(scn.nextLine());
        newCategoria.setCategoriaId(counter);
        counter++;

        LstCategorias.add(newCategoria);
    }

    public void AgregarIngreso() {
        Ingreso newIngreso = new Ingreso();

        for (Concepto concpto : LstConceptos) {
            System.out.println("Id Concepto: " + concpto.getConceptoId() + " Nombre: " + concpto.getNombre());
        }

        System.out.println("Ingrese el id de concepto correspondiente:");
        newIngreso.setConceptoId(scn.nextInt());

        System.out.println("Ingrese el total");

        float total = scn.nextFloat();
        saldo += total;
        newIngreso.setTotal(total);

        Date fecha = new Date();
        newIngreso.setFecha(fecha);
        newIngreso.setIngresoId(counter);
        counter++;

        LstIngreso.add(newIngreso);
    }

    public void AgregarEgreso() {
        Egreso newEgreso = new Egreso();

        for (Concepto concpto : LstConceptos) {
            System.out.println("Id Concepto: " + concpto.getConceptoId() + " Nombre: " + concpto.getNombre());
        }

        System.out.println("Ingrese el id de concepto correspondiente:");
        newEgreso.setConceptoId(scn.nextInt());

        System.out.println("Ingrese el total");
        float total = scn.nextFloat();
        saldo -= total;
        newEgreso.setTotal(total);

        Date fecha = new Date();
        newEgreso.setFecha(fecha);
        newEgreso.setEgresoId(counter);
        counter++;

        LstEgreso.add(newEgreso);
    }

    public void VerResumen() {
        System.out.println("Ingrese la opcion que desea: ");
        System.out.println("1- Reporte de Gastos por rango de fechas");
        System.out.println("2- Reporte de Ingresos por rango de fechas");
        System.out.println("3- Resumen de Ingreso-Egreso por rangos de fechas");

        int opcion = scn.nextInt();

        switch (opcion) {
            case 1:
                // llamar metodo reporte gastos
                break;
            case 2:
                // metodo de ingresos
                break;
            case 3:
                // metodo ambos
                break;
            default:
                System.out.println("Opcion no valida.");
                break;
        }
    }

    public void ReporteGastos() throws Exception {
        System.out.println("Ingrese la fecha de Inicio en formato dd/mm/yyyy");
        String fechaInicio = scn.nextLine();
        System.out.println("Ingrese la fecha de fin en formato dd/mm/yyyy");
        String fechaFin = scn.nextLine();

        Date inicio = new SimpleDateFormat("dd/mm/yyyy").parse(fechaInicio);
        Date fin = new SimpleDateFormat("dd/mm/yyyy").parse(fechaFin);

        List<Egreso> LstGastos = LstEgreso.stream().filter(egr -> egr.getFecha().compareTo(inicio) > 0 && egr.getFecha().compareTo(fin) < 0 ).collect(Collectors.toList());

        Comparator<Egreso> comparador = new Comparator<Egreso>() {
            @Override
            public int compare(Egreso o1, Egreso o2) {
                return o1.getFecha().compareTo(o2.getFecha());
            }
        };

        Collections.sort(LstGastos, comparador);

        float total = 0.0f;

        for (Egreso egr : LstGastos) {
            Concepto concept = GetConceptoById(egr.getConceptoId());
            System.out.println("Concepto " + concept.getNombre());
            System.out.println("Total gastado " + egr.getTotal());
            System.out.println("Fecha " + egr.getFecha());
            total += egr.getTotal();
        }
        
        System.out.println("Total gastado: " + total);
    }

    public void ReporteIngresos()throws Exception {
        System.out.println("Ingrese la fecha de Inicio en formato dd/mm/yyyy");
        String fechaInicio = scn.nextLine();
        System.out.println("Ingrese la fecha de fin en formato dd/mm/yyyy");
        String fechaFin = scn.nextLine();

        Date inicio = new SimpleDateFormat("dd/mm/yyyy").parse(fechaInicio);
        Date fin = new SimpleDateFormat("dd/mm/yyyy").parse(fechaFin);
        
        List<Ingreso> LstEngreso = LstIngreso.stream().filter(egr -> egr.getFecha().compareTo(inicio) > 0 && egr.getFecha().compareTo(fin) < 0 ).collect(Collectors.toList());
    }
    
    public Concepto GetConceptoById(int id) {
        for (Concepto c : LstConceptos) {
            if (c.getConceptoId() == id) {
                return c;
            }
        }
        return null;
    }
}
