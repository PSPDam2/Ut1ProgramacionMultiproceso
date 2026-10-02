package Ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> datos = new ArrayList<>();
 
        // Se piden números hasta que se escriba "*" (sin validar nada)
        String linea;
        do {
            System.out.println("Escribe un número:");
            linea = sc.nextLine();
            datos.add(linea);
        } while (!linea.trim().equals("*"));
 
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "java", "-cp", System.getProperty("java.class.path"),
                    "Ejercicio2.Ejercicio2");
            pb.redirectErrorStream(true);
            Process p = pb.start();
 
            // Pasamos los datos recogidos a la entrada estándar del hijo
            try (BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(p.getOutputStream()))) {
                for (String d : datos) {
                    bw.write(d);
                    bw.newLine();
                }
            }
 
            // Leemos toda la salida del hijo
            List<String> salida = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()))) {
                String l;
                while ((l = br.readLine()) != null) salida.add(l);
            }
 
            int codigo = p.waitFor();
            if (codigo > 127) codigo -= 256; // normaliza en Linux/Mac
 
            System.out.println("Valor de Salida: " + codigo);
            salida.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
