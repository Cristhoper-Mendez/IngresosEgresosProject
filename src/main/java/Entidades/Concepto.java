package Entidades;

public class Concepto {

    int ConceptoId;

    String Nombre;
    int Tipo;
    int CategoriaId;

    public int getConceptoId() {
        return ConceptoId;
    }

    public void setConceptoId(int ConceptoId) {
        this.ConceptoId = ConceptoId;
    }

    public int getCategoriaId() {
        return CategoriaId;
    }

    public void setCategoriaId(int CategoriaId) {
        this.CategoriaId = CategoriaId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

}
