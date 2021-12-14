package co.com.automatizacion.newexperience.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features="src/test/resources/features/Compra/compra_de_productos.feature",
		plugin = {"pretty"},
		glue = {"co.com.automatizacion.newexperience.stepdefinitions", "co.com.automatizacion.newexperience.hook"},
		monochrome = true,
		dryRun = false,
		snippets = SnippetType.CAMELCASE)

public class CompraDeProductos {}