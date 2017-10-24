package lab2.DoDomu;

import java.io.*;
import java.util.LinkedList;
import java.util.Random;

    public class CwDB {
        protected LinkedList<Entry> dict;

        public CwDB(String filename) throws IOException {
            createDB(filename);
        }

        public void add(String word, String clue){
            Entry new_word=new Entry(word,clue);
            dict.add(new_word);

        }
        public Entry get(String word){
            for(int i=0; i<dict.size(); i++){
                if(dict.get(i).getWord().equals(word)){
                    return dict.get(i);
                }
            }
            return null;
        }

        public void remove(String word){
            for(int i=0; i<dict.size(); i++){
                if(dict.get(i).getWord().equals(word)){
                    dict.remove(i);
                    break;
                }
            }
        }

        public void saveDB(String filename) throws IOException{
            PrintWriter zapis = new PrintWriter(filename);
            for(int i=0; i<dict.size();i++){
                zapis.println(dict.get(i).getWord());
                zapis.println(dict.get(i).getClue());
            }
            zapis.close();
        }

        public int getSize(){
            return dict.size();
        }
        protected void createDB(String filename) throws IOException {
            dict=new LinkedList<>();
            BufferedReader file = null;
            try {
                file = new BufferedReader(new FileReader(filename));
                String word="";
                String clue="";
                String odczyt = file.readLine();
                while (odczyt != null) {
                    word =odczyt;
                    odczyt=file.readLine();
                    clue=odczyt;
                    add(word,clue);
                    odczyt = file.readLine();
                }
            } finally {
                if (file != null) {
                    file.close();
                }

            }
        }

    }

