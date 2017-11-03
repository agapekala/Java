package lab4.zad5;

public class Polibiusz implements Algorithm {

    @Override
    public String crypt(String to_crypt) {
        int first, second;
        String l_first="", l_second="", str="";
        String new_word=to_crypt.toUpperCase();
        for(int i=0; i<to_crypt.length();i++){
            if(new_word.charAt(i)>73){
                if((new_word.charAt(i)-65)%5==0){
                    first=(new_word.charAt(i)-65)/5;
                }
                else{
                    first =(((new_word.charAt(i)) - 65)/5)+1;
                }
                if((new_word.charAt(i)-65)%5==0){
                    second=5;
                }
                else{
                    second = (((new_word.charAt(i)) - 65)%5);
                }
            }
            else{
                if((new_word.charAt(i)-64)%5==0){
                    first=(new_word.charAt(i)-64)/5;
                }
                else{
                    first =(((new_word.charAt(i)) - 64)/5)+1;
                }
                if((new_word.charAt(i)-64)%5==0){
                    second=5;
                }
                else{
                    second = (((new_word.charAt(i)) - 64)%5);
                }
            }
            l_first = Integer.toString(first);
            l_second= Integer.toString(second);
            str +=l_first;
            str +=l_second;
        }
        return str;
    }

    @Override
    public String decrypt(String to_decrypt) {
        String str="";
        int n_first, n_second;
        char letter;
        for(int i=0; i<to_decrypt.length(); i+=2){
            n_first=to_decrypt.charAt(i)-48;
            n_second=to_decrypt.charAt(i+1)-48;
            letter=(char)(n_second+(n_first-1)*5);
            if(letter>9){
                letter+=97;
            }
            else {
                letter += 96;
            }
            str+=letter;
        }
        return str;
    }
}
