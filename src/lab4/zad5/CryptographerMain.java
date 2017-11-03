package lab4.zad5;

import java.io.IOException;
import java.util.Scanner;

public class CryptographerMain {
    public static void main(String[] args) throws IOException{
        Algorithm al1=new ROT11();
        Algorithm al2=new Polibiusz();
        System.out.println("Plik wejściowy: ");
        Scanner odczyt = new Scanner(System.in);
        String path_in = odczyt.nextLine();

        System.out.println("Plik wyjściowy: ");
        odczyt = new Scanner(System.in);
        String path_out = odczyt.nextLine();

        System.out.println("Co chcesz zrobić?: ");
        System.out.println("(1) szyfrowanie");
        System.out.println("(2) deszyfrowanie");

        odczyt=new Scanner(System.in);
        int wybor=odczyt.nextInt();

        System.out.println("Rodzaj szyfru: ");
        System.out.println("(1) ROT11");
        System.out.println("(2) Polibiusz");

        odczyt=new Scanner(System.in);
        int szyfr=odczyt.nextInt();

        if(wybor==1){
            if(szyfr==1){
                Cryptographer.cryptfile(path_in,
                        path_out, al1);
            }else if(szyfr==2){
                Cryptographer.cryptfile(path_in,path_out,al2);
            }else{
                System.out.println("Niewłaściwy wybór szyfru");
            }
        }else if(wybor==2){
            if(szyfr==1){
                Cryptographer.decryptfile(path_in,
                        path_out, al1);
            }else if(szyfr==2){
                Cryptographer.decryptfile(path_in,path_out,al2);
            }else{
                System.out.println("Niewłaściwy wybór szyfru");
            }
        }else{
            System.out.println("Niewłaściwy wybór");
        }

    }
}
