package lab9;

import lab9.Leven;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {

    public static void main(String[] args) throws IOException {
        //short port = Short.parseShort(args[0]);
        short port =6666;
        ExecutorService services = Executors.newFixedThreadPool(2);//inicjalizacja executora
        try(ServerSocket srv = new ServerSocket(port)){
            while(true) {
                Socket s = srv.accept();
                System.out.print("new connection accepted: ");
                System.out.println(s.getInetAddress());
                services.submit(new SockReader(s));
            }
        }
    }
}

class SockReader implements Runnable {
    static String login1="aga";
    static String login2="login2";
    static String login3="login3";
    static String haslo1="zza";
    static String haslo2="turecku";
    static String haslo3="fortun";

    static Integer id1=1234567890;
    static Integer id2=1234567891;
    static Integer id3=1234567892;
    static Leven l=new Leven();
    private Scanner in;
    private PrintStream out;
    private Socket s;

    public SockReader(Socket s) throws IOException {
        this(s.getInputStream(),s.getOutputStream());
        this.s = s;
    }

    public SockReader(InputStream input, OutputStream output) {
        in = new Scanner(input);
        out = new PrintStream(output);
    }

    private void msg(String msg) {
        System.out.print("SRV: ");
        System.out.println(msg);
    }
    public void run() {
        msg("serving new connection");
        while( (!Thread.currentThread().isInterrupted()) && in.hasNextLine() ) {

            String line = in.nextLine();
            String[] result=line.split(" ");

            if(result.length<2 || result.length>3){
                out.println("Niewłaściwe polecenie");
            }
            String polecenie=result[0];
            String tekst=result[1];
            String dodatkowe="";
            if(result.length==3){
                dodatkowe=result[2];
            }

            if(polecenie.equals("LOGIN")) {
                login(out,tekst);
            }else if(polecenie.equals("LOGOUT")){
                out.println(logout(out,tekst));

            }else if(polecenie.equals("LS")){
                ls(out,tekst);
            }else if(polecenie.equals("GET")){
                try {
                    get(out, tekst, dodatkowe);
                }catch (Exception e){
                    System.out.println(e);
                }
            }
            else{
                out.println("nieznane polecenie");
            }

        }
        try {
            out.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        msg("connection closed");
    }
    static public void login(PrintStream out, String tekst){
        String[] res=tekst.split(";");
        String pswd=res[1];
        String log=res[0];
        if(log.equals(login1)) {
            if (pswd.equals(haslo1)) {
                out.println("Zalogowano " + id1);
            } else {
                out.println(l.levenDistance(pswd, haslo1));
            }
        }else if(log.equals(login2) ) {
            if (pswd.equals(haslo2)) {
                out.println("Zalogowano " + id2);
            } else {
                out.println(l.levenDistance(pswd, haslo2));
            }
        }

        else if(log.equals(login3) ) {
            if (pswd.equals(haslo3)) {
                out.println("Zalogowano " + id3);
            } else {
                out.println(l.levenDistance(pswd, haslo3));
            }
        }
        }


    static public boolean logout(PrintStream out,String tekst){
        int tekst_int=Integer.parseInt(tekst);
        if(tekst_int==id1 || tekst_int==id2 || tekst_int==id3){
            return true;
        }
        else{
            return false;
        }
    }

    static public void ls(PrintStream out,String tekst){
        int tekst_int=Integer.parseInt(tekst);
        String result="";
        if(tekst_int==id1 || tekst_int==id2 ||tekst_int==id3){
            File[] lista=finder("/home/agnieszka/IdeaProjects/Java/src/lab9");
            for(int i=0; i<lista.length-1;i++){
                result+=lista[i].getName();
                result+=';';
            }
            result+=lista[lista.length-1].getName();
            out.println(result);
        }
        else{
            out.println(false);
        }
    }

    static public File[] finder( String dirName ){
        File dir = new File(dirName);

        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename)
            { return filename.endsWith("txt"); }
        } );

    }

    static public void get(PrintStream out,String tekst, String dod) throws Exception{
        int tekst_int=Integer.parseInt(tekst);
        String result="";
        if(tekst_int==id1 ||tekst_int==id2 || tekst_int==id3) {
            String dir="/home/agnieszka/IdeaProjects/Java/src/lab9/"+dod;
            BufferedReader br = new BufferedReader(new FileReader(dir));
            String line = null;
            while ((line = br.readLine()) != null) {
                result+=line+";";
            }
            out.println(result);
        }
        else{
            out.println(false);
        }
    }
}