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
    private int counterConcepto = 1;
    private int counterCategoria = 1;
    private int counterIngreso = 1;
    private int counterEgreso = 1;
    private float saldo = 0.0f;
    private Comparator<Egreso> comparadorEgreso = new Comparator<Egreso>() {
        @Override
        public int compare(Egreso o1, Egreso o2) {
            return o1.getFecha().compareTo(o2.getFecha());
        }
    };
    private Comparator<Ingreso> comparadorIngreso = new Comparator<Ingreso>() {
        @Override
        public int compare(Ingreso o1, Ingreso o2) {
            return o1.getFecha().compareTo(o2.getFecha());
        }
    };

    public Mantenimiento() {
        this.scn = new Scanner(System.in);
    }

    public void AgregarConcepto() {

        if (LstCategorias.isEmpty()) {
            System.out.println("No se ha registrado ninguna Categoria");
        } else {
            Concepto concpto = new Concepto();
            String nombre_concepto;
            int tipo;
            System.out.println("\n\nLISTA DE CATEGORIAS:");
            System.out.println("Id Categoria:\t\tNombre: ");
            for (Categoria cat : LstCategorias) {
                System.out.println(cat.getCategoriaId() + "\t\t\t" + cat.getNombre());
            }
            System.out.println("\nIngrese el id de categoria correspondiente.");
            int categoriaId = scn.nextInt();
            concpto.setCategoriaId(categoriaId);
            System.out.println("Ingrese la descripcion de concepto.");
            nombre_concepto = scn.next();
            concpto.setNombre(nombre_concepto);

            concpto.setConceptoId(counterConcepto);
            counterConcepto++;

            LstConceptos.add(concpto);
        }
    }

    public void AgregarCategoria() {
        String categoria;
        Categoria newCategoria = new Categoria();
        System.out.println("Ingrese el nombre de la categoria.");
        categoria = scn.nextLine();
        newCategoria.setNombre(categoria);
        newCategoria.setCategoriaId(counterCategoria);
        counterCategoria++;

        LstCategorias.add(newCategoria);

    }

    public void AgregarIngreso() {
        try {
            Ingreso newIngreso = new Ingreso();
            int idConcepto;
            ListarConceptos();

            System.out.println("\n\nIngrese el id de concepto correspondiente:");
            idConcepto = scn.nextInt();
            newIngreso.setConceptoId(idConcepto);

            System.out.println("Ingrese el total");
            float total = scn.nextFloat();
            saldo += total;
            newIngreso.setTotal(total);

            System.out.println("Ingrese la fecha");
            String fecha = LeerFechaValida();
            Date fechaParseada = new SimpleDateFormat("dd/mm/yyyy").parse(fecha);
            newIngreso.setFecha(fechaParseada);
            newIngreso.setIngresoId(counterIngreso);
            counterIngreso++;

            LstIngreso.add(newIngreso);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void AgregarEgreso() {

        try {
            Egreso newEgreso = new Egreso();

            ListarConceptos();
            System.out.println("\n\nIngrese el id de concepto correspondiente:");
            int idConcepto = scn.nextInt();
            newEgreso.setConceptoId(idConcepto);

            System.out.println("Ingrese el total");
            float total = scn.nextFloat();
            saldo -= total;
            newEgreso.setTotal(total);

            System.out.println("Ingrese la fecha");
            String fecha = LeerFechaValida();
            Date fechaParseada = new SimpleDateFormat("dd/mm/yyyy").parse(fecha);
            newEgreso.setFecha(fechaParseada);
            newEgreso.setEgresoId(counterEgreso);
            counterEgreso++;

            LstEgreso.add(newEgreso);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void ListarConceptos() {
        System.out.println("\n\nLISTA DE CONCEPTOS:");
        System.out.println("Id concepto\t\tDescripcion\t\tCategoria");
        Categoria categoria;
        for (Concepto concpto : LstConceptos) {
            categoria = LstCategorias.stream().filter(x -> x.getCategoriaId() == concpto.getCategoriaId()).findFirst().orElse(null);
            System.out.println(concpto.getConceptoId() + "\t\t" + concpto.getNombre() + "\t\t" + categoria.getNombre());
        }
    }

    public void VerResumen() {
        System.out.println("Ingrese la opcion que desea: ");
        System.out.println("1- Reporte de Gastos por rango de fechas");
        System.out.println("2- Reporte de Ingresos por rango de fechas");
        System.out.println("3- Resumen de Ingreso-Egreso por rangos de fechas");

        int opcion = scn.nextInt();

        try {
            switch (opcion) {
                case 1:
                    this.ReporteGastos();
                    break;
                case 2:
                    this.ReporteIngresos();
                    break;
                case 3:
                    this.ReporteGastos();
                    this.ReporteIngresos();
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private void ReporteGastos() throws Exception {

        System.out.println("Fecha de Inicio:");
        System.out.println("------------------------------------");
        String fechaInicio = LeerFechaValida();
        System.out.println("Ingrese la fecha de Fin");
        System.out.println("------------------------------------");
        String fechaFin = LeerFechaValida();
        Date inicio = new SimpleDateFormat("dd/mm/yyyy").parse(fechaInicio);
        Date fin = new SimpleDateFormat("dd/mm/yyyy").parse(fechaFin);

        List<Egreso> LstGastos = LstEgreso.stream().filter(egr -> egr.getFecha().compareTo(inicio) > 0 && egr.getFecha().compareTo(fin) < 0).collect(Collectors.toList());

        Collections.sort(LstGastos, comparadorEgreso);

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

    private void ReporteIngresos() throws Exception {
        System.out.println("Fecha de Inicio:");
        System.out.println("------------------------------------");
        String fechaInicio = LeerFechaValida();
        System.out.println("Ingrese la fecha de Fin");
        System.out.println("------------------------------------");
        String fechaFin = LeerFechaValida();

        Date inicio = new SimpleDateFormat("dd/mm/yyyy").parse(fechaInicio);
        Date fin = new SimpleDateFormat("dd/mm/yyyy").parse(fechaFin);

        List<Ingreso> LstEngreso = LstIngreso.stream().filter(egr -> egr.getFecha().compareTo(inicio) > 0 && egr.getFecha().compareTo(fin) < 0).collect(Collectors.toList());

        Collections.sort(LstEngreso, comparadorIngreso);

        float total = 0.0f;

        for (Ingreso igr : LstEngreso) {
            Concepto concept = GetConceptoById(igr.getConceptoId());
            System.out.println("Concepto " + concept.getNombre());
            System.out.println("Total ingresado " + igr.getTotal());
            System.out.println("Fecha " + igr.getFecha());
            total += igr.getTotal();
        }

        System.out.println("Ingresos totales: " + total);
    }

    private Concepto GetConceptoById(int id) {
        for (Concepto c : LstConceptos) {
            if (c.getConceptoId() == id) {
                return c;
            }
        }
        return null;
    }

    private String LeerFechaValida() {
        int dia, mes, año;
        System.out.println("ingrese el dia (numeros)");
        dia = scn.nextInt();
        System.out.println("ingrese el mes (numeros)");
        mes = scn.nextInt();
        System.out.println("ingrese el año (numeros)");
        año = scn.nextInt();
        return String.format("%d/%d/%d", dia, mes, año);
    }
}
