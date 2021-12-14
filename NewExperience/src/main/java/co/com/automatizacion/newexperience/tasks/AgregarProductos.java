package co.com.automatizacion.newexperience.tasks;

import co.com.automatizacion.newexperience.model.Prenda;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.automatizacion.newexperience.ui.Menu.LNK_MENU;
import static co.com.automatizacion.newexperience.ui.Productos.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarProductos implements Task {

	private Prenda prenda;

	public AgregarProductos(Prenda prenda) {
		this.prenda = prenda;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.remember( prenda.getNombrePrenda() , prenda );

		actor.attemptsTo(
				WaitUntil.the(LNK_MENU.of(prenda.getCategoria()), isPresent()),
				Click.on(LNK_MENU.of(prenda.getCategoria())),
				Scroll.to(DIV_PRENDA.of(prenda.getNombrePrenda())),
				HoverOverElement.over(DIV_PRENDA.of(prenda.getNombrePrenda()))
		);

		actor.attemptsTo(
				WaitUntil.the(LNK_ADD_TO_CART.of(prenda.getNombrePrenda()), isVisible()),
				Click.on(LNK_ADD_TO_CART.of(prenda.getNombrePrenda()))
		);

		actor.attemptsTo(
				WaitUntil.the(SPAN_CLOSE_WINDOWS, isVisible()),
				Click.on(SPAN_CLOSE_WINDOWS)
		);
	}

	public static AgregarProductos alCarrito(Prenda prenda) {
		return instrumented(AgregarProductos.class, prenda);
	}
}