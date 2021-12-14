package co.com.automatizacion.newexperience.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.automatizacion.newexperience.ui.ProcesoDeCompras.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConfirmaElMetodoDeEnvio implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(
				Click.on(CHK_TERMINOS),
				Click.on(BTN_CONFIRMAR_METODO_DE_ENVIO)
		);
	}

	public static ConfirmaElMetodoDeEnvio deLosProductos() {
		return instrumented(ConfirmaElMetodoDeEnvio.class);
	}
}