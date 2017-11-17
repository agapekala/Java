package kolos;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class WeWy {
    public static Stack<Operator> pobierzDzialanie() throws Exception{
        Stack<Operator> stack=new Stack<>();
        File file= new File("/home/agnieszka/IdeaProjects/Java/src/kolos/test");
        Scanner fis=new Scanner(file);
        String linia=fis.nextLine();
        for(int i=0; i<linia.length();i++) {
            char znak=linia.charAt(i);
            if (znak >= 48 && znak <= 57) {
                Operator op = new Stała(znak);
                stack.push(op);
            } else if (znak == '*') {
                Operator op = new Mnożenie(znak);
                stack.push(op);
            } else if (znak == '/') {
                Operator op = new Dzielenie(znak);
                stack.push(op);
            } else if (znak == '+') {
                Operator op = new Dodawanie(znak);
                stack.push(op);
            } else if(znak=='!'){
                Operator op = new Silnia(znak);
                stack.push(op);
            }else{
                i++;
            }
        }
        return stack;

    }

    public static void zapiszWynik(Double v){
        System.out.println(v);
    }
}
