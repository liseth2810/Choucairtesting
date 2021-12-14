package co.com.automatizacion.newexperience.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Fecha {

	/**
	 * @param fecha string Con formato (yyyy/MM/dd)
	 * @param dias a sumar
	 * @return fecha calculada string con formato (yyyy-MM-dd)
	 */
	public static String sumarAlDia(String fecha, int dias) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = formatter.parse(fecha.replace("/", "-"));
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_YEAR, (dias - 1));
			return formatter.format(cal.getTime()).replace("-", "/");
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * @param fecha string Con formato (yyyy/MM/dd)
	 * @param meses a sumar
	 * @return fecha calculada string con formato (yyyy-MM-dd)
	 */
	public static String sumarAlMes(String fecha,int meses) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = formateador.parse(fecha.replace("/", "-"));
			cal.setTime(date);
			cal.add(Calendar.MONTH, (meses)); 
			return  formateador.format(cal.getTime()).replace("-", "/");
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * @return fecha Actual - string con formato (yyyy/MM/dd)
	 * 1 = fecha -> anio / mes / dia
	 * 2 = fecha -> dia / mes / anio
	 */
	public static String fechaActual(int parametro) {
		String dia;
		String mes;
		String anio;
		Calendar cal = Calendar.getInstance();
		dia = String.valueOf(cal.get(5));
		mes = String.valueOf(cal.get(2) + 1);
		anio = String.valueOf(cal.get(1));
		if (Integer.valueOf(dia) < 10) {
			dia = "0" + dia;
		}
		if (Integer.valueOf(mes) < 10) {
			mes = "0" + mes;
		}
		
		switch (parametro) {
		case 1: 
			return anio + "/" + mes + "/" + dia;
	
		case 2: 
			return dia + "/" + mes + "/" + anio;
	
			
		default:
				return null;
		}
	}

	/**
	 * @throws ParseException 
	 * 
	 */
	public static String formatoFecha(String fecha, String nuevoFormato) throws ParseException {
		
		final String OLD_FORMAT = "yyyy/MM/dd"; 
		final String NEW_FORMAT = nuevoFormato; 
		String oldDateString = fecha;
		SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT); 
		Date d = sdf.parse(oldDateString); 
		sdf.applyPattern(NEW_FORMAT); 
		
		return sdf.format(d);	
	}

	 /**
	 * @return String día Actual
	 */
	public static String diaActual() {
		String dia;
		Calendar cal = Calendar.getInstance();
		
		dia = String.valueOf(cal.get(5));
		if (Integer.valueOf(dia) < 10) {
			dia = "0" + dia;
		}
		return dia;
	}

	 /**
	 * @return String mes Actual
	 */
	public String mesActual() {
		String mes;
		Calendar cal = Calendar.getInstance();
		mes = String.valueOf(cal.get(2) + 1);

		if (Integer.valueOf(mes) < 10) {
			mes = "0" + mes;
		}
		return mes;
	}

	 /**
	 * @return String nombre mes Actual
	 */
	public static String nombreMesActual() {
		String nombreDelMes = Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG, new Locale("es", "ES"));
		return nombreDelMes.replaceFirst("^[a-z]", nombreDelMes.substring(0,1).toUpperCase());
	}

	 /**
	 * @return String anio Actual
	 */
	public static String anioActual() {
		String anio;
		Calendar cal = Calendar.getInstance();
		anio = String.valueOf(cal.get(1));
		return anio;
	}
}