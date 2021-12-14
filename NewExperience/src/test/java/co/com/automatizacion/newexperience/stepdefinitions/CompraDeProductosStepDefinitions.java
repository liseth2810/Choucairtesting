package co.com.automatizacion.newexperience.stepdefinitions;

import co.com.automatizacion.newexperience.exceptions.ElPedidoNoSeRealizoSatisfactoriaMente;
import co.com.automatizacion.newexperience.exceptions.ElPrecioTotalNoEsCorrecto;
import co.com.automatizacion.newexperience.model.Prenda;
import co.com.automatizacion.newexperience.model.Usuario;
import co.com.automatizacion.newexperience.questions.Mensaje;
import co.com.automatizacion.newexperience.questions.PrecioTotal;
import co.com.automatizacion.newexperience.tasks.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.hamcrest.Matchers;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class CompraDeProductosStepDefinitions {



	@Dado("que liseth inicia sesion correctamente")
	public void queLisethIniciaSesion(List<Usuario> credenciales) throws InterruptedException {

		theActorInTheSpotlight().wasAbleTo(
				InicioDeSesion.con(credenciales.get(0))
		);
	}

	@Cuando("agrega productos al carrito")
	public void agregaProductosAlCarrito(List<Prenda> productos) {
		productos.forEach(producto ->{
			theActorInTheSpotlight().attemptsTo(
					AgregarProductos.alCarrito(producto)
			);
		});
	}

	@Y("realiza el proceso de compras")
	public void realizaElProcesoDeCompras() {

		theActorInTheSpotlight().attemptsTo(
				RealizaElcheckout.deLosProductos(),
				ConfirmaLaDireccion.deEnvio(),
				ConfirmaElMetodoDeEnvio.deLosProductos(),
				EligeMetodoDePago.porCheque(),
				ConfirmaPedido.deLosProductos()
		);
	}

	@Entonces("liseth puede visualizar que su pedido esta completado")
	public void lisethPuedeVisualizaElDetalleYEstadoDeSuPedido() {

		theActorInTheSpotlight().should(
				seeThat(Mensaje.deConfirmacionDePedido(), Matchers.equalTo(true)).orComplainWith(ElPedidoNoSeRealizoSatisfactoriaMente.class)
		);

	}

	@Entonces("vissualiza el precio total a pagar")
	public void vissualizaElPrecioTotalAPagar() {

		theActorInTheSpotlight().should(
				seeThat(PrecioTotal.aPagar(), Matchers.equalTo(true)).orComplainWith(ElPrecioTotalNoEsCorrecto.class)
		);

	}
}