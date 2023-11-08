
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

	        double porcentajeCorrectas = (preguntasCorrectas / (double) NUMERO_PREGUNTAS) * 100;
	        System.out.println("Porcentaje de respuestas correctas: " + porcentajeCorrectas + "%");

	        if (porcentajeCorrectas < 75) {
	            System.out.println("Por favor pide ayuda adicional a tu instructor.");
	        } else {
	            System.out.println("¡Felicidades, estás listo para pasar al siguiente nivel!");
	        }
	    }

	    private static int seleccionarNivelDificultad() {
	        System.out.println("Elige el nivel de dificultad:");
	        System.out.println("1. Números de un dígito");
	        System.out.println("2. Números de dos dígitos");
	        // Puedes agregar más niveles de dificultad aquí si lo deseas

	        return scanner.nextInt();
	    }

	    private static int seleccionarTipoProblema() {
	        System.out.println("Elige el tipo de problema aritmético:");
	        System.out.println("1. Suma");
	      