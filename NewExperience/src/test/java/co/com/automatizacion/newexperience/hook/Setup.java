package co.com.automatizacion.newexperience.hook;

import co.com.automatizacion.newexperience.model.Prenda;
import co.com.automatizacion.newexperience.model.Usuario;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Setup {

    private final static String RUTA_URL_FRONT = "url.baseurl";

    static EnvironmentVariables environmentVariable;
    public static String urlBaseFront;

    static {

        environmentVariable = Injectors.getInjector().getInstance(EnvironmentVariables.class);
        urlBaseFront = EnvironmentSpecificConfiguration.from(environmentVariable).getProperty(RUTA_URL_FRONT);
    }

    @Managed(driver = "chrome")
    public WebDriver driver;

    @Before(order = 1)
    public void configurarActor() {
        //Que inicie el show!
        OnStage.setTheStage(new OnlineCast());

        // Otorgar habilidad al actor para navegar por la Web.
        theActorCalled("Liseth").can(BrowseTheWeb.with(driver));

        theActorInTheSpotlight().wasAbleTo(Open.url(urlBaseFront));
    }

    @DataTableType
    public Usuario cargarModeloUsuario(Map<String, String> entry) {
        return new Usuario(
                entry.get("usuario"),
                entry.get("contrasena")
        );
    }

    @DataTableType
    public Prenda cargarModeloPrenda(Map<String, String> entry) {
        return new Prenda(
                entry.get("categoria"),
                entry.get("prenda"),
                entry.get("precio")
        );
    }
}
