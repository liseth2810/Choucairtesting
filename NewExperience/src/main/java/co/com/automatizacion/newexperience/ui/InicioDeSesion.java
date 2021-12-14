package co.com.automatizacion.newexperience.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class InicioDeSesion {

	public static final Target LNK_LOGIN = Target.the("Link para iniciar login").located(By.linkText("Sign in"));
	public static final Target TXT_EMAIL = Target.the("Campo email").located(By.id("email"));
	public static final Target TXT_PASS = Target.the("Campo Password").located(By.id("passwd"));
	public static final Target BNT_SIGN_IN = Target.the("Campo Password").located(By.id("SubmitLogin"));




	private InicioDeSesion() {}
}
