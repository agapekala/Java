package lab5.zad4;

import io.indico.Indico;
import io.indico.api.utils.IndicoException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public class Test {
    public static void main(String[] argv) throws IOException, IndicoException, NoConnection, WrongData {
        Indico indico = null;
        LinkedList<File> list=new LinkedList<File>();
        Sort s=new Sort();
        try {
            s.key(indico);
        }catch(IndicoException | IOException | NoConnection e){
            throw e;
        }
         try{
            s.direct("/home/agnieszka/Obrazy/foto", list);
         }catch(FileNotFoundException | WrongData e){
            throw e;
         }
        for(File f:list){
            Indico indico2 = new Indico("f5825ecab6d61db1179062bc738904c0");
            s.imageSort(indico2, f,"/home/agnieszka/Obrazy/foto", list);
        }
    }
}
