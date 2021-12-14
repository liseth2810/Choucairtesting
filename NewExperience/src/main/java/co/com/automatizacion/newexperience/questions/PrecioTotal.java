package co.com.automatizacion.newexperience.questions;


import co.com.automatizacion.newexperience.model.Prenda;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static co.com.automatizacion.newexperience.util.Constantes.*;


@Subject("Verifica que el precio total pagado es correcto")
public class PrecioTotal implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        float valorDeEnvio = 2;

        Prenda vestido = actor.recall(VESTIDO.getValor());
        Prenda camisa = actor.recall(CAMISETA.getValor());

        float totalEsperado = valorDeEnvio + Float.parseFloat(vestido.getPrecio().replace("$","")) + Float.parseFloat(camisa.getPrecio().replace("$",""));


        String PrecioFinalObtenido = actor.recall(PRECIO_TOTAL.getValor()).toString().replace("$","");

        return (totalEsperado == Float.parseFloat(PrecioFinalObtenido));
    }

    public static PrecioTotal aPagar() {

        return new PrecioTotal();
    }
}