package lab2.DoDomu;

import java.io.IOException;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;

public class InteliCwDB extends CwDB {
    public InteliCwDB(String filename) throws IOException{
        super(filename);
    }

    public LinkedList<Entry> findAll(String pattern){
        LinkedList<Entry> new_list=new LinkedList<>();
        Pattern pattern1=Pattern.compile(pattern);
        for(int i=0; i<dict.size();i++) {
            Matcher matcher = pattern1.matcher(dict.get(i).getWord());
            if(matcher.find()){
                Entry new_entry=new Entry(dict.get(i).getWord(), dict.get(i).getClue());
                new_list.add(new_entry);
            }
        }
        return new_list;
    }

    public Entry getRandom(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(dict.size());
        return dict.get(randomInt);
    }
    public Entry getRandom(int length){
        LinkedList<Entry> help_list=new LinkedList<>();
        for(int i=0; i<dict.size(); i++){
            if(dict.get(i).getWord().length()==length){
                help_list.add(dict.get(i));
            }
        }
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(help_list.size());
        return help_list.get(randomInt);
    }

    public Entry getRandom(String pattern){
        LinkedList<Entry> help_list;
        help_list=findAll(pattern);
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(help_list.size());
        return help_list.get(randomInt);
    }

    @Override
    public void add(String word, String clue) {
        Entry new_word = new Entry(word, clue);
        if (dict.isEmpty()) {
            dict.add(new_word);
        } else {
            for (int i = 0; i < dict.size()-1; i++) {
                if (word.compareTo(dict.get(i).getWord().toLowerCase()) > 0 && word.compareTo(dict.get(i+1).getWord().toLowerCase())<0) {
                    dict.add(i + 1, new_word);
                    break;
                }
            }
            dict.addLast(new_word);
        }
    }
}