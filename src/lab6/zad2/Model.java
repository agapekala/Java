package lab6.zad2;

import java.util.LinkedList;

import static java.lang.Character.isDigit;

public class Model {
    public String wsp_;
    public String od_;
    public String do_;
    public String prob_;
    public LinkedList<Double> wsp_num=new LinkedList<>();
    public int od_num;
    public int do_num;
    public double prob_num;

    public void wspToNum(){
        String help="";
        for(int i=0; i<wsp_.length(); i++){
            if(isDigit(wsp_.charAt(i)) || wsp_.charAt(i)=='-'){
                help+=wsp_.charAt(i);
            }else{
                wsp_num.add(Double.parseDouble(help));
                help="";
            }
        }
        wsp_num.add(Double.parseDouble(help));
    }

    public void zakresToNum(){
        od_num=Integer.parseInt(od_);
        do_num=Integer.parseInt(do_);
    }

    public void probToNum(){
        prob_num=Double.parseDouble(prob_);
    }

    public double policzWart(double x) {
        double wynik=0;
        for(int i=0; i< wsp_num.size(); i++){
            wynik+=wsp_num.get(i)*Math.pow(x,wsp_num.size()-1-i);
        }
        return wynik;
    }

}
