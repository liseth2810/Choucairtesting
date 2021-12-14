package co.com.automatizacion.newexperience.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.automatizacion.newexperience.ui.Menu.LNK_CART;
import static co.com.automatizacion.newexperience.ui.ProcesoDeCompras.LNK_PROCEED_TO_CHECKOUT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RealizaElcheckout implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Scroll.to(LNK_CART),
				Click.on(LNK_CART),
				WaitUntil.the(LNK_PROCEED_TO_CHECKOUT, isVisible()),
				Click.on(LNK_PROCEED_TO_CHECKOUT)
		);
	}

	public static RealizaElcheckout deLosProductos() {
		return instrumented(RealizaElcheckout.class);
	}
}