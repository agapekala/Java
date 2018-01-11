package lab9;

import sun.awt.image.ImageWatched;

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.Executor;

public class EchoClient {
    static Leven l = new Leven();
    static boolean find_pass = false;

    static int leven=0;
    static String sample_word="";
    static LinkedList<String> lista=new LinkedList<>();

    public static void main(String[] args) throws IOException {
        String file = "/home/agnieszka/Pobrane/fetch.txt";
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("localhost", 6666);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }
        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput="";

        String textLine = bufferedReader.readLine();
        sample_word=textLine;
        System.out.println("Wpisz komendę: ");
        //userInput = "";

userInput=stdIn.readLine();
String input;
try {
    int i=0;
    while (userInput != null) {
        if (find_pass){
            String login=userInput.substring(5,userInput.length());
            input = "LOGIN "+login+";" + lista.get(i);
            out.println(input);
            String serwer=in.readLine();
            System.out.println("echo: " + serwer+" Haslo: "+lista.get(i));
            if(i==lista.size()){
                find_pass=false;
                userInput=stdIn.readLine();
            }
            if(serwer.charAt(0)=='Z'){
                find_pass=false;
                userInput=stdIn.readLine();
            }
            i++;
        }else {
            if (userInput.charAt(0)=='p') {
                find_pass = true;
                String login=userInput.substring(5,userInput.length());
                input = "LOGIN "+login+";" + textLine;

                System.out.println("userInput to " + input);
                out.println(input);
                leven = Integer.parseInt(in.readLine());
                System.out.println("echo: " + leven);

                lista = findPswd();
                System.out.println(lista.size());
            } else {
                find_pass = false;

                out.println(userInput);
                System.out.println("echo: " + in.readLine());
                userInput = stdIn.readLine();

            }
        }


    }

}catch (Exception e){

}
        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();


    }

    static public LinkedList<String> findPswd() throws Exception {
        LinkedList<String> lista = new LinkedList<>();
        FileReader fileReader = new FileReader("/home/agnieszka/Pobrane/fetch.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String textLine = bufferedReader.readLine();
        int result;
        do {
            result=l.levenDistance(sample_word,textLine);
            if(result==leven){
                lista.add(textLine);
            }

            textLine = bufferedReader.readLine();
        } while(textLine != null);

        bufferedReader.close();

        return lista;
    }
}