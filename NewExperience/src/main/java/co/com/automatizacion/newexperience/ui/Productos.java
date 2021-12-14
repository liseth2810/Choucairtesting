package co.com.automatizacion.newexperience.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Productos {

	public static final Target DIV_PRENDA = Target.the("Seleccionar Prenda").locatedBy("(//a[@title='{0}'])[2]");
	public static final Target LNK_ADD_TO_CART = Target.the("Agregar al carrito").locatedBy("(//a[@title='{0}']//following::a[@title='Add to cart'])[1]");
	public static final Target SPAN_CLOSE_WINDOWS = Target.the("Cerrar ventana emergente").locatedBy("//span[@title='Close window']");

	private Productos() {}
}
