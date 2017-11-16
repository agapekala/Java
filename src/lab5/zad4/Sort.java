package lab5.zad4;

import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;
import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;
import static jdk.nashorn.internal.objects.NativeNumber.valueOf;

public class Sort {
    public void key(Indico indico) throws IndicoException, IOException, NoConnection {
        if (InetAddress.getLocalHost().isReachable(5)) {
            indico = new Indico("f5825ecab6d61db1179062bc738904c0");
        } else {
            System.out.println("Brak połączenia");
            throw new NoConnection();
        }
    }
    public void direct(String name, LinkedList<File> files) throws WrongData, FileNotFoundException {
        File dir = new File(name);
        if(!dir.exists()){
            throw new FileNotFoundException();
        }
        File[] in = dir.listFiles();
        Pattern pattern = compile(".+\\.jpg");
        Matcher m;
        for (int i = 0; i < in.length; i++) {
            m = pattern.matcher(in[i].toString());
            if (m.find()) {
                files.add(in[i]);
            } else {
                System.out.println("Zły typ danych");
                throw new WrongData();
            }
        }
    }



    public String mapSort(Map<String, Double> img_map) {
        LinkedList<Pair> pairs = new LinkedList<>();
        for (Map.Entry<String, Double> entry : img_map.entrySet()) {
            pairs.add(new Pair(entry.getKey(), entry.getValue()));
        }
        Collections.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                double value1 = valueOf(o1.getValue());
                double value2 = valueOf(o2.getValue());
                if (value1 > value2) {
                    return 1;
                } else if (value1 < value2) {
                    return -1;
                } else
                    return 0;
            }
        });
        return pairs.getLast().getKey().toString();
    }
    public void imageSort(Indico indico, File file, String name, LinkedList<File> files)throws IOException, IndicoException{
        IndicoResult single = indico.imageRecognition.predict(file);
        Map<String, Double> result = single.getImageRecognition();
        mapSort(result);
        File dir = new File(name+"/"+mapSort(result));
        dir.mkdir();
        file.renameTo(new File(name+"/"+mapSort(result)+"/"+file.getName()));
    }
}
