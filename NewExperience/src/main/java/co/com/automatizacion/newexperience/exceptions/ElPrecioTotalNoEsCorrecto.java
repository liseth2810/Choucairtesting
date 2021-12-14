package co.com.automatizacion.newexperience.exceptions;

@SuppressWarnings("serial")
public class ElPrecioTotalNoEsCorrecto extends AssertionError {

	public ElPrecioTotalNoEsCorrecto() {

		super("El precio total del pedido es incorrecto");
	}
}
