package Testing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingRussia {
    // механихм парсинга русских слов и добавление в массив
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

        Pattern pattern = Pattern.compile("[а-я]");
        for (String text: e){
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()){
                pars = text.substring(matcher.start()); //по буковке
                second.add(pars); //добавление буквы
                break;
            }
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

    public void output(ArrayList<String> strings){
        for (String re: strings){
            System.out.println(re);
        }

    }

}
