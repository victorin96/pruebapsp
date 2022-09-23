package Ejemplo2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Padre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("cuantas lineas quieres mostrar");
        int contador = sc.nextInt();

        ProcessBuilder pb = new ProcessBuilder("java","src/Ejemplo2/Hijo.java");
        pb.redirectErrorStream(true);

        try {
            Process hijo = pb.start();
            //----------- LECTURA ----------
            //cojo la entrada estandar del hijo
            InputStream isHijo = hijo.getInputStream();
            //creo un lector para la entrada
            InputStreamReader isrHijo = new InputStreamReader(isHijo, StandardCharsets.UTF_8);
            //creo un buffer para leer linea a linea y no char a char
            BufferedReader brhijo = new BufferedReader(isrHijo);

            //---------- ESCRITURA ----------
            OutputStream os = hijo.getOutputStream();
            PrintStream psHijo = new PrintStream(os);

            psHijo.println(contador);
            psHijo.flush();

            String respuesta;
            while ((respuesta = brhijo.readLine()) != null){
                System.out.println(respuesta);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
