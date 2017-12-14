package lab8.zad4;

import lab1.Pesel.PeselChecker;

public class Test {
    public static void main(String []args){
        PeselChecker pesel=new PeselChecker("97062709422");
        Pracownik pr;
        Pracownik new_pr=new PracownikEtat();
        new_pr.setBrutto(20.45);
        new_pr.setPesel(new PeselChecker("81100216357"));
        Kadry k=new Kadry();
        k.find(pesel);
        //System.out.println(k.pr.getPesel());
        //k.add(new_pr);
        //k.remove(new_pr);
        System.out.println(k.getBrutto(new_pr));
        k.changeBrutto(new_pr,30.50);
        System.out.println(k.getBrutto(new_pr));
    }
}
