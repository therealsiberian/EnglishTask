package Testing;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingEnglish {
    // механихм парсинга английских слов и добавление в массив
    private ArrayList<String> parsed = new ArrayList<>();
    private ArrayList<String> parsed2 = new ArrayList<>();

    public ArrayList<String> getParsed2() {
        return parsed2;
    }

    public ArrayList<String> getParsed() {
        return parsed;
    }
    public ArrayList<String> adding(ArrayList<String> arr) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\Soft\\text.txt")));
        String line;
        while((line = reader.readLine()) != null) {
            arr.add(line);
        }
        return arr;
    }

    public ArrayList<String> parsing(ArrayList<String> e, ArrayList<String> second){
        String pars = "";

        Pattern pattern = Pattern.compile("[a-z]");
        for (String text: e){
            Matcher matcher = pattern.matcher(text); //первая строка листа
            while (matcher.find()){

                pars = pars.concat(text.substring(matcher.start(),matcher.end())); //по буковке

            }

// pars = pars.concat("\n");
            second.add(pars); //добавление слова
            pars = "";
        }

        return second;
    }

public ArrayList<String> deleteEmpty (ArrayList<String> a){
        for (int i = 0; i<a.size();i++){
            if(a.get(i).isEmpty()){
                a.remove(i);
i--;
            }
        }

        return a;
}

//    public void output(ArrayList<String> strings){
//        for (String re: strings){
//            System.out.println(re);
//        }
//
//    }

}
