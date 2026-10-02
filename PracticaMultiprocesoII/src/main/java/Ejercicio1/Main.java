package Ejercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un número entero positivo:");
        String dato = sc.nextLine();

        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "java", "-cp", System.getProperty("java.class.path"),
                    "Ejercicio1", dato);
            pb.inheritIO();
            int codigo = pb.start().waitFor();

            // En Linux/Mac el código de salida va de 0 a 255 (-1 -> 255, -2 -> 254...)
            if (codigo > 127) codigo -= 256;

            switch (codigo) {
                case -1: System.out.println("No has escrito nada"); break;
                case -2: System.out.println("No has escrito un entero"); break;
                case -3: System.out.println("Has escrito un entero positivo"); break;
                case 0:  System.out.println("El entero debe ser positivo"); break;
                default: System.out.println("Código inesperado: " + codigo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
