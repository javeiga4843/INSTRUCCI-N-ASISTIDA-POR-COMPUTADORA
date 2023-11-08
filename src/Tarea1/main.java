
package Tarea1;


	import java.security.SecureRandom;
	import java.util.Scanner;
	public class main {

	    private static final int NUMERO_PREGUNTAS = 10;

	    private static final String[] RESPUESTAS_POSITIVAS = {
	            "¡Muy bien!",
	            "¡Excelente!",
	            "¡Buen trabajo!",
	            "¡Sigue así!"
	    };

	    private static final String[] RESPUESTAS_NEGATIVAS = {
	            "No. Por favor intenta de nuevo.",
	            "Incorrecto. Intenta una vez más.",
	            "¡No te rindas!",
	            "No. Sigue intentando."
	    };

	    private static final SecureRandom random = new SecureRandom();
	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        int nivelDificultad = seleccionarNivelDificultad();
	        int tipoProblema = seleccionarTipoProblema();

	        int preguntasCorrectas = 0;
	        for (int i = 0; i < NUMERO_PREGUNTAS; i++) {
	            if (realizarPregunta(nivelDificultad, tipoProblema)) {
	                preguntasCorrectas++;
	                System.out.println(obtenerResultadoPositivoAlazar());
	            } else {
	                System.out.println(obtenerResultadoNegativoAlazar());
	            }
	        }

	       