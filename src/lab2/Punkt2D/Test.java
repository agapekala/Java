package lab2.Punkt2D;

import lab2.Punkt2D.Punkt3D;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Test {
    public static void wczytanie(List<Punkt3D> punkty){
        int x, y, z;
        System.out.println("Podaj współrzędne punktu: ");
        Scanner read = new Scanner(System.in);
        x = read.nextInt();
        y = read.nextInt();
        z = read.nextInt();
        Punkt3D pkt = new Punkt3D(x, y, z);
        punkty.add(pkt);
    }

    public static void wypisz(List<Punkt3D> punkty){
        System.out.println("Wszyskie punkty:");
        for (int i = 0; i < punkty.size(); i++) {
            System.out.println("Punkt "+i+":");
            System.out.println(punkty.get(i).getX()+", "+punkty.get(i).getY()+", "+punkty.get(i).getZ());
        }
    }
    public static void odleglosc(List<Punkt3D> punkty){
        int a,b;
        System.out.println("Wybierz numery dwóch puktów z listy: ");
        Scanner read1 = new Scanner(System.in);
        a=read1.nextInt();
        b=read1.nextInt();
        double dist=punkty.get(a).distance(punkty.get(b));
        System.out.println("Odległość: "+dist);
    }

    public static void main(String[] args) {
        List<Punkt3D> punkty=new LinkedList<>();
        System.out.println("1. Wczytaj punkt 3D");
        System.out.println("2. Wyświetl wszystkie punkty");
        System.out.println("3. Oblicz odległość");
        System.out.println("4. Zakończ");
        System.out.println("?");
        boolean flag=true;
        int number;
        while (flag) {
            System.out.println();
            System.out.println("Co chcesz zrobić?: ");
            Scanner odczyt = new Scanner(System.in);
            number = odczyt.nextInt();
            switch (number) {
                case 1:
                    wczytanie(punkty);
                    break;
                case 2:
                    wypisz(punkty);
                    break;
                case 3:
                    odleglosc(punkty);
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Niewłaściwy wybór");

            }
        }

    }
}