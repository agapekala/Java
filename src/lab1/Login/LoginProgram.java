package lab1.Login;

import java.io.*;
public class LoginProgram {
    public static void main(String[] argv){
        Login log = new Login ("ala", "makota");
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            String login = bfr.readLine();
            String haslo = bfr.readLine();

            if(log.check(login, haslo)) System.out.println("Dane prawidłowe");
            else System.out.println("Dane błędne");

        }catch(IOException e){e.printStackTrace();}
    }
}
