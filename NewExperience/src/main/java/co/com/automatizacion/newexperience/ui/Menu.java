package co.com.automatizacion.newexperience.ui;

import net.serenitybdd.screenplay.targets.Target;

public class Menu {

	public static final Target LNK_MENU = Target.the("Link Menu")
			.locatedBy("(//a[text()='{0}'])[2]");

	public static final Target LNK_CART = Target.the("Link Carrito de compras")
			.locatedBy("//a[@title='View my shopping cart']");

	private Menu() {}
}
