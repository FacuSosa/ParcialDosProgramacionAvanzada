package ar.edu.unlam.pb2.parcial2;

import java.util.Calendar;

public class Reloj {
	public static long ahora() {
		return Calendar.getInstance().getTimeInMillis();
	}
}