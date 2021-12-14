package co.com.automatizacion.newexperience.questions;


import co.com.automatizacion.newexperience.util.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import static co.com.automatizacion.newexperience.ui.ProcesoDeCompras.LBL_CONFIRMAR_PEDIDO;


@Subject("Obtiene el mensaje que indica que su pedido esta completado")
public class Mensaje implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        String mensaje = Text.of(LBL_CONFIRMAR_PEDIDO).viewedBy(actor).asString();

        return Constantes.MENSAJE_CONFIRMACION_DE_PEDIDO.getValor().equals(mensaje);
    }

    public static Mensaje deConfirmacionDePedido() {

        return new Mensaje();
    }
}