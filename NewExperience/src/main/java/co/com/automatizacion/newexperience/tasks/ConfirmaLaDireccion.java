package co.com.automatizacion.newexperience.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.automatizacion.newexperience.ui.ProcesoDeCompras.BTN_CONFIRMAR_DIRECCION_DE_ENVIO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConfirmaLaDireccion implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(
				WaitUntil.the(BTN_CONFIRMAR_DIRECCION_DE_ENVIO, isVisible()),
				Click.on(BTN_CONFIRMAR_DIRECCION_DE_ENVIO)
		);
	}

	public static ConfirmaLaDireccion deEnvio() {
		return instrumented(ConfirmaLaDireccion.class);
	}
}