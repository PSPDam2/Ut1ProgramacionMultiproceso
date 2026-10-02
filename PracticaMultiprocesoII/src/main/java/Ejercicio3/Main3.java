package Ejercicio3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un texto:");
        String texto = sc.nextLine();
 
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "java", "-cp", System.getProperty("java.class.path"),
                    "Ejercicio3.Ejercicio3", texto);
            pb.redirectErrorStream(true);
            Process p = pb.start();
 
            StringBuilder sb = new StringBuilder();
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()))) {
                String l;
                while ((l = br.readLine()) != null) sb.append(l).append("\n");
            }
 
            int codigo = p.waitFor();
            if (codigo > 127) codigo -= 256;
 
            System.out.println("Valor de Salida: " + codigo);
            System.out.print(sb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
