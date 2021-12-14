package co.com.automatizacion.newexperience.model;

public class Prenda {

    private String categoria;
    private String nombrePrenda;
    private String precio;

    public Prenda(String categoria, String nombrePrenda, String precio) {
        this.categoria = categoria;
        this.nombrePrenda = nombrePrenda;
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getNombrePrenda() {
        return nombrePrenda;
    }

    public String getPrecio() {
        return precio;
    }
}
