package classes;

import static org.junit.Assert.*;

public class Validador {
	
	public static void validarResultado(String resultadoEsperado, String resultadoEncontrado) {
		assertEquals(resultadoEsperado, resultadoEncontrado);
	}

}