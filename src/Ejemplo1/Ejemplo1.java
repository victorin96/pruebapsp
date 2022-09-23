package Ejemplo1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Ejemplo1 {
    /*
    * App que abre el chrome con la pagina de progresa cargada
    *
    * */
    public static void main(String[] args) {
        //Comandos -> Array de string
        //elemento 1 el programa
        //siguientes cada una de argumentos a arrancar
        String[] comando = {"open","-a","Google Chrome", "www.cieep.com"};
        String[] comando2 = {"open","/System/Applications/Textedit.app"};
        //String[] comandoWin = {"notepad",""};
        //crear proceso con el processbuilder
        String[] hijo = {"java","src/Ejemplo1/ProcesoHijo.java"};
        ProcessBuilder pb = new ProcessBuilder(hijo);

        //creamos el proceso hijo
        try {
            Process pSafari = pb.start();
            if(pSafari.isAlive())
                TimeUnit.SECONDS.sleep(30);
            pSafari.destroy();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
