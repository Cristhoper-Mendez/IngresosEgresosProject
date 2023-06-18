package Entidades;

public class Categoria {

    int CategoriaId;
    String Nombre;

    public Categoria() {
    }

    public Categoria(int CategoriaId, String Nombre) {
        this.CategoriaId = CategoriaId;
        this.Nombre = Nombre;
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
}
