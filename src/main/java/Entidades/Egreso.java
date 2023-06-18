package Entidades;

import java.util.Date;

public class Egreso {

    int ConceptoId;
    int EgresoId;
    double Total;
    Date fecha;

    public Egreso() {
    }

    public Egreso(int ConceptoId, int EgresoId, double Total, Date fecha) {
        this.ConceptoId = ConceptoId;
        this.EgresoId = EgresoId;
        this.Total = Total;
        this.fecha = fecha;
    }

    public int getConceptoId() {
        return ConceptoId;
    }

    public void setConceptoId(int ConceptoId) {
        this.ConceptoId = ConceptoId;
    }

    public int getEgresoId() {
        return EgresoId;
    }

    public void setEgresoId(int EgresoId) {
        this.EgresoId = EgresoId;
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
