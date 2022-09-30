package Ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hijo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String enviarPalabra = br.readLine().toUpperCase();
        System.out.println(enviarPalabra);
    }
}
