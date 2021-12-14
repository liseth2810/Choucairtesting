package co.com.automatizacion.newexperience.exceptions;

@SuppressWarnings("serial")
public class ElPedidoNoSeRealizoSatisfactoriaMente extends AssertionError {

	public ElPedidoNoSeRealizoSatisfactoriaMente() {

		super("El actor no pudo confirmar el mensaje del pedido");
	}
}
