
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
	        System.out.println("2. Resta");
	        System.out.println("3. Multiplicación");
	        System.out.println("4. División");
	        System.out.println("5. Mezcla aleatoria");

	        return scanner.nextInt();
	    }

	    private static boolean realizarPregunta(int nivelDificultad, int nivelProblema) {
	        int num1 = mostrarNumeroAlazar(nivelDificultad);
	        int num2 = mostrarNumeroAlazar(nivelDificultad);
	        String operador = obtenerOperador(nivelProblema);

	        int resultadoEsperado = obtenerResultado(num1, num2, operador);
	        int respuestaUsuario;

	        do {
	            System.out.print("¿Cuánto es " + num1 + " " + operador + " " + num2 + "? ");
	            respuestaUsuario = scanner.nextInt();

	            if (respuestaUsuario == resultadoEsperado) {
	                return true;
	            } else {
	                System.out.println("Respuesta incorrecta. Intenta nuevamente.");
	            }
	        } while (true);
	    }

	    private static int mostrarNumeroAlazar(int nivelDificultad) {
	        int maximo;

	        switch (nivelDificultad) {
	            case 1:
	                maximo = 10;
	                break;
	            case 2:
	                maximo = 100;
	                break;
	            default:
	                maximo = 10;
	                break;
	        }

	        return random.nextInt(maximo) + 1;
	    }

	    private static String obtenerOperador(int tiponivel) {
	        switch (tiponivel) {
	            case 1:
	                return "+";
	            case 2:
	                return "-";
	            case 3:
	                return "*";
	            case 4:
	                return "/";
	            case 5:
	                return obtenerOperadorAlazar();
	            default:
	                return "+";
	        }
	    }

	    private static String obtenerOperadorAlazar() {
	        String[] operadores = {"+", "-", "*", "/"};
	        int indice = random.nextInt(operadores.length);
	        return operadores[indice];
	    }

	    private static int obtenerResultado(int num1, int num2, String operador) {
	        int resultado;

	        switch (operador) {
	            case "+":
	                resultado = num1 + num2;
	                break;
	            case "-":
	                resultado = num1 - num2;
	                break;
	            case "*":
	                resultado = num1 * num2;
	                break;
	            case "/":
	                resultado = num1 / num2;
	                break;
	            default:
	                resultado = num1 + num2;
	                break;
	        }

	        return resultado;
	    }

	    private static String obtenerResultadoPositivoAlazar() {
	        int indice = random.nextInt(RESPUESTAS_POSITIVAS.length);
	        return RESPUESTAS_POSITIVAS[indice];
	    }

	    private static String obtenerResultadoNegativoAlazar() {
	        int indice = random.nextInt(RESPUESTAS_NEGATIVAS.length);
	        return RESPUESTAS_NEGATIVAS[indice];
	    }
	
}
