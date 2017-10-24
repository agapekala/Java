package lab1.Pesel;

import java.util.Scanner;
public class Pesel {
    public static void main(String[] args) {

        System.out.println("Podaj pesel: ");
        PeselChecker pesel;
        Scanner odczyt = new Scanner(System.in);
        String stringpesel = odczyt.nextLine();
        pesel = new PeselChecker(stringpesel);
        System.out.println(pesel.getPesel());
        if(pesel.Checker()==true){
            System.out.println("Pesel jest ok!");
        }
        else{
            System.out.println("Pesel jest zły");
        }
    }
}