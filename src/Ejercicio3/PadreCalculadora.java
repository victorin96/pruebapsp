package Ejercicio3;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PadreCalculadora {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        menu();
        int eleccion = sc.nextInt();
        sc.nextLine();

        switch (eleccion) {
            case 1 -> {
                Resta();
            }
            case 2 -> {
                Suma();
            }
            case 3 -> {
                Multiplicacion();
            }
            case 4 -> {
                Division();
            }
        }
    }

    private static void Division() {

        System.out.println("dime un numero");
        int num7 = sc.nextInt();
        System.out.println("dime el segundo numero");
        int num8 = sc.nextInt();
        ProcessBuilder pbdiv = new ProcessBuilder("java", "src/Ejercicio3/HijoDiv.java");
        pbdiv.redirectErrorStream(true);
        try {
            ProcesoHijos(pbdiv, num7, num8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void Multiplicacion() {

        System.out.println("dime un numero");
        int num5 = sc.nextInt();
        System.out.println("dime el segundo numero");
        int num6 = sc.nextInt();
        ProcessBuilder pbmult = new ProcessBuilder("java", "src/Ejercicio3/HijoMult.java");
        pbmult.redirectErrorStream(true);
        try {
            ProcesoHijos(pbmult, num5, num6);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void Suma() {

        System.out.println("dime un numero");
        int num3 = sc.nextInt();
        System.out.println("dime el segundo numero");
        int num4 = sc.nextInt();
        ProcessBuilder pbsuma = new ProcessBuilder("java", "src/Ejercicio3/HijoSuma.java");
        pbsuma.redirectErrorStream(true);
        try {
            ProcesoHijos(pbsuma, num3, num4);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void Resta() {

        System.out.println("dime un numero");
        int num1 = sc.nextInt();
        System.out.println("dime el segundo numero");
        int num2 = sc.nextInt();
        ProcessBuilder pbresta = new ProcessBuilder("java", "src/Ejercicio3/HijoResta.java");
        pbresta.redirectErrorStream(true);
        try {
            ProcesoHijos(pbresta, num1, num2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void menu() {

        System.out.println("Elige una opcion: ");
        System.out.println("1. Restar");
        System.out.println("2. Sumar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Todas");
        System.out.println("6. Salir");
    }
    private static void ProcesoHijos(ProcessBuilder pb, int num1, int num2) throws IOException {

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

        psHijo.println(num1);
        psHijo.flush();// SIMULA EL INTRO

        psHijo.println(num2);
        psHijo.flush();

        String respuesta = brhijo.readLine();
        System.out.println(respuesta);
    }
}
