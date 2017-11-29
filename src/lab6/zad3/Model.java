package lab6.zad3;

import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Pair;
import lab5.zad4.WrongData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;
import static jdk.nashorn.internal.objects.NativeNumber.valueOf;

public class Model {
    public void direct(String name, LinkedList<String> files) throws WrongData, FileNotFoundException {
        File dir = new File(name);
        if (!dir.exists()) {
            throw new FileNotFoundException();
        }
        File[] in = dir.listFiles();
        Pattern pattern = compile(".+\\.jpg");
        Matcher m;
        for (int i = 0; i < in.length; i++) {
            m = pattern.matcher(in[i].toString());
            if (m.find()) {
                files.add(in[i].getName());
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

    public Map<String, Double> recognize(String path) throws IndicoException, IOException{
        File file=new File(path);
        Indico indico = new Indico("f5825ecab6d61db1179062bc738904c0");
        IndicoResult single = indico.imageRecognition.predict(file);
        Map<String, Double> result = single.getImageRecognition();
        mapSort(result);
        return result;
    }
}
