package Testing;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Result {
    //механизм проверки английских слов

    public static void main(String[] args) throws IOException {
        ParsingEnglish parsingEnglish = new ParsingEnglish();
        parsingEnglish.adding(parsingEnglish.getParsed());
        parsingEnglish.parsing(parsingEnglish.getParsed(),parsingEnglish.getParsed2());
        parsingEnglish.deleteEmpty(parsingEnglish.getParsed2());
        ParsingRussia parsingRussia = new ParsingRussia();
        parsingRussia.adding(parsingRussia.getParsed());
        parsingRussia.parsing(parsingRussia.getParsed(),parsingRussia.getParsed2());
        parsingRussia.deleteEmpty(parsingRussia.getParsed2());//
        Random random = new Random();
        ArrayList<Integer> repeat = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int wrongAnswers = 0;
        int attempts = 5;


        for (int i = 0;i<attempts; i++){
            int randomNumber = random.nextInt(parsingEnglish.getParsed2().size()-1);
            for(Integer re: repeat){
                if(re==randomNumber){

                    randomNumber =random.nextInt(parsingEnglish.getParsed2().size()); //это чтобы было меньше вероятности повтора
                    break;
                }
            }

            repeat.add(randomNumber);
            String questionWord = parsingRussia.getParsed2().get(randomNumber);
            System.out.println("In english please - \"" + questionWord + "\" ?");
            String yourAnswer = reader.readLine();
            if (yourAnswer.equals(parsingEnglish.getParsed2().get(randomNumber))){
                System.out.println("You are right!");

            }else{
                System.out.println("No, it's wrong");
                System.out.println("The right answer is \"" + parsingEnglish.getParsed2().get(randomNumber) + "\"");
                System.out.println();
                wrongAnswers++;
            }

        }

        System.out.println("There are "+ wrongAnswers + " wrong answer(s) of " + attempts + " attempts");
        double wr = wrongAnswers;
        double at = attempts;
        double percent = (wr/at) *100;
        double t = 100.0-percent;
          //      System.out.println("Or "+ t + "%" );


     reader.close();
    }
}
