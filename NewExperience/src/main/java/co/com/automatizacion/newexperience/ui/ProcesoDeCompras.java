package co.com.automatizacion.newexperience.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProcesoDeCompras {

	public static final Target LNK_PROCEED_TO_CHECKOUT = Target.the("Link para Proceed to checkout")
			.locatedBy("//a[starts-with(@class,'button btn')  and @title='Proceed to checkout']");

	public static final Target BTN_CONFIRMAR_DIRECCION_DE_ENVIO = Target.the("Boton Confirmar direccion")
			.located(By.name("processAddress"));

	public static final Target CHK_TERMINOS = Target.the("Aceptar terminos")
			.located(By.id("cgv"));

	public static final Target BTN_CONFIRMAR_METODO_DE_ENVIO = Target.the("Boton Confirmar metodo de envio")
			.located(By.name("processCarrier"));

	public static final Target LBL_PAGO_TOTAL = Target.the("Label precio total")
			.located(By.id("total_price"));

	public static final Target LNK_PAGO_CON_CHEQUE = Target.the("link para pagar con cheque")
			.locatedBy("//a[@title='Pay by check.']");

	public static final Target BTN_CONFIRMAR_ORDEN = Target.the("Confirmar Orden")
			.locatedBy("//p[@id='cart_navigation']//button");

	public static final Target LBL_CONFIRMAR_PEDIDO = Target.the("Mensaje de Confirmacion")
			.locatedBy("//p[@class='alert alert-success']");



	private ProcesoDeCompras() {}
}
