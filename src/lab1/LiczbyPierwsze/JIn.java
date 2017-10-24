package lab1.LiczbyPierwsze;

import javax.swing.*;
import java.io.*;

public class JIn {
    public static String getString() {
        String text = null;
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            text = bfr.readLine();
        }catch(IOException e){e.printStackTrace();}
        return text;
    }
    public static int getInt(){
        String intBuffer = null;
        int inputNumber = 0;
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);
            intBuffer=bfr.readLine();
            inputNumber = Integer.parseInt(intBuffer);
        }catch(IOException e){e.printStackTrace();}
        return inputNumber;
    }
}
