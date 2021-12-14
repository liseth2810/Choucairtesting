package co.com.automatizacion.newexperience.tasks;

import static co.com.automatizacion.newexperience.ui.InicioDeSesion.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.automatizacion.newexperience.model.Usuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class InicioDeSesion implements Task {

	private Usuario usuario;

	public InicioDeSesion(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Click.on(LNK_LOGIN),
				WaitUntil.the(TXT_EMAIL, isVisible()),
				Enter.theValue(usuario.getUsuario()).into(TXT_EMAIL),
				Enter.theValue(usuario.getContrasena()).into(TXT_PASS),
				Click.on(BNT_SIGN_IN)
		);
	}

	public static InicioDeSesion con(Usuario usuario) {
		return instrumented(InicioDeSesion.class, usuario);
	}
}
