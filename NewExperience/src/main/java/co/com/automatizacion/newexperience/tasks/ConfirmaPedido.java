package co.com.automatizacion.newexperience.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.automatizacion.newexperience.ui.ProcesoDeCompras.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConfirmaPedido implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(
				Click.on(BTN_CONFIRMAR_ORDEN)

		);
	}

	public static ConfirmaPedido deLosProductos() {
		return instrumented(ConfirmaPedido.class);
	}
}