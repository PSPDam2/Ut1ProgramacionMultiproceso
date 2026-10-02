package Ejercicio3;

public class Ejercicio3 {
	public static void main(String[] args) {
        if (args.length == 0) {
            System.exit(-1);
        }
        String limpia = args[0].toLowerCase().replaceAll("[^\\p{L}\\p{N}]", "");
        String reves = new StringBuilder(limpia).reverse().toString();
 
        if (limpia.equals(reves)) {
            System.out.println("Es palíndromo");
        } else {
            System.out.println("NO es palíndromo");
        }
        System.exit(0);
    }

}
