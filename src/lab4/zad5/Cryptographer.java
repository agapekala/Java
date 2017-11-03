package lab4.zad5;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Cryptographer {

    static public void cryptfile(String file_to_encrypt, String file_to_save, Algorithm algorithm) throws IOException{
        String word="";
        String encrypted_word="";
        String encrypted_file="";
            FileInputStream file = new FileInputStream(file_to_encrypt);
            int in = file.read();
            while (in != -1) {
                if(in!=32 && in!='\n'){
                    word+=(char)in;

                } else{
                    encrypted_word=algorithm.crypt(word);
                    encrypted_file+=encrypted_word;
                    encrypted_file+=(char)in;
                    word="";
                }
                in = file.read();
            }
            encrypted_word=algorithm.crypt(word);
            encrypted_file+=encrypted_word;


        PrintWriter zapis = new PrintWriter(file_to_save);
        zapis.println(encrypted_file);

    }
    static public void decryptfile(String file_to_decrypt, String file_to_save, Algorithm algorithm) throws IOException{
        String word="";
        String decrypted_word="";
        String decrypted_file="";
        FileInputStream file = new FileInputStream(file_to_decrypt);
        int in = file.read();
        while (in != -1) {
            if(in!=32 && in!='\n'){
                word+=(char)in;

            } else{
                decrypted_word=algorithm.decrypt(word);
                decrypted_file+=decrypted_word;
                decrypted_file+=(char)in;
                word="";
            }
            in = file.read();
        }
        decrypted_word=algorithm.decrypt(word);
        decrypted_file+=decrypted_word;

        PrintWriter zapis = new PrintWriter(file_to_save);
        zapis.println(decrypted_file);
        zapis.close();

    }
}