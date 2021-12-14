package co.com.automatizacion.newexperience.tasks;

import co.com.automatizacion.newexperience.util.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.automatizacion.newexperience.ui.ProcesoDeCompras.LBL_PAGO_TOTAL;
import static co.com.automatizacion.newexperience.ui.ProcesoDeCompras.LNK_PAGO_CON_CHEQUE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EligeMetodoDePago implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {

		String precioTotal = LBL_PAGO_TOTAL.resolveFor(actor).getText();

		actor.remember( Constantes.PRECIO_TOTAL.getValor(), precioTotal );

		actor.attemptsTo(
				Click.on(LNK_PAGO_CON_CHEQUE)
		);
	}

	public static EligeMetodoDePago porCheque() {
		return instrumented(EligeMetodoDePago.class);
	}
}