package co.com.automatizacion.newexperience.util;

public enum Constantes {

    VESTIDO("Printed Chiffon Dress"),
    CAMISETA("Faded Short Sleeve T-shirts"),
    PRECIO_TOTAL("Precio total"),
    MENSAJE_CONFIRMACION_DE_PEDIDO("Your order on My Store is complete.");

    final String constante;

    Constantes(String constante) {
        this.constante = constante;
    }

    public String getValor() {
        return constante;
    }
}
