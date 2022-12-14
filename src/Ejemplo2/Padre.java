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
            InputStream isHijo = hijo.getInputStream();// OJO salida del hijo
            //creo un lector para la entrada
            InputStreamReader isrHijo = new InputStreamReader(isHijo, StandardCharsets.UTF_8);
            //creo un buffer para leer linea a linea y no char a char
            BufferedReader brhijo = new BufferedReader(isrHijo); //LEE LOS SOUT DEL HIJO

            //---------- ESCRITURA ----------
            OutputStream os = hijo.getOutputStream();// CAPTURA LA ENTRADA DEL HIJO (SCANNER DEL HIJO)
            PrintStream psHijo = new PrintStream(os);

            psHijo.println(contador);
            psHijo.flush();// SIMULA EL INTRO

            String respuesta;
            //usamos while porque recibimos mas de una respuesta. 10 lineas por ejemplo
            while ((respuesta = brhijo.readLine()) != null){
                System.out.println(respuesta);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
