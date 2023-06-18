package Entidades;

import java.util.Date;

public class Ingreso {

    int IngresoId;
    int ConceptoId;
    double Total;
    Date fecha;

    public Ingreso() {
    }

    public Ingreso(int ConceptoId, int IngresoId, double Total, Date fecha) {
        this.ConceptoId = ConceptoId;
        this.IngresoId = IngresoId;
        this.Total = Total;
        this.fecha = fecha;
    }

    public int getConceptoId() {
        return ConceptoId;
    }

    public void setConceptoId(int ConceptoId) {
        this.ConceptoId = ConceptoId;
    }

    public int getIngresoId() {
        return IngresoId;
    }

    public void setIngresoId(int IngresoId) {
        this.IngresoId = IngresoId;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
