package lab4.zad5;

public class ROT11 implements Algorithm {

    static String alphabet="abcdefghijklmnopqrstuvwxyz";
    static int rotation=11;

    @Override
    public String crypt(String to_crypt) {
        String crypted="";
        for(int i=0; i<to_crypt.length(); i++){
            if(to_crypt.charAt(i)>=97 && to_crypt.charAt(i)<=122){
                crypted=crypted+alphabet.charAt(((to_crypt.charAt(i)-97)+rotation)%alphabet.length());
            }
            else{
                crypted=crypted+alphabet.toUpperCase().charAt(((to_crypt.charAt(i)-65)+rotation)%alphabet.length());
            }
        }
        return crypted;
    }

    @Override
    public String decrypt(String to_decrypt) {
        String decrypted="";
        for(int i=0; i<to_decrypt.length(); i++){
            if(to_decrypt.charAt(i)>=97 && to_decrypt.charAt(i)<=122){
                decrypted=decrypted+alphabet.charAt(((to_decrypt.charAt(i)-97)+(alphabet.length()-rotation))%alphabet.length());
            }
            else{
                decrypted=decrypted+alphabet.toUpperCase().charAt(((to_decrypt.charAt(i)-65)+(alphabet.length()-rotation))%alphabet.length());
            }
        }
        return decrypted;
    }
}
