package Ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HijoResta {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num1recibido = br.readLine();
        int num1 = Integer.parseInt(num1recibido);
        String num2recibido = br.readLine();
        int num2 = Integer.parseInt(num2recibido);
        int resta = num1-num2;
        System.out.println(resta);

    }
}
