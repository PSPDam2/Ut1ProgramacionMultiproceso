
package Ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double suma = 0;
 
        while (sc.hasNextLine()) {
            String linea = sc.nextLine().trim();
 
            if (linea.equals("*")) {
                System.out.println("Escrito *");
                break;
            }
            if (linea.matches("[-+]?\\d+(\\.\\d+)?")) {
                suma += Double.parseDouble(linea);
                System.out.println("Escrito " + linea);
            } else {
                System.exit(-1); // es una cadena
            }
        }
        System.out.println("Suma: " + suma);
        System.exit(0);
    }

}
