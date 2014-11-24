package flashcards.vocab.com.germanvocab.parser;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by ajit on 19.11.14.
 */
public class URLConnection {


    public static final  String DOMAIN_NAME ="http://www.memrise.com/course/920/5000-german-words-top-87/";



    public    ArrayList<FlashCard>  getAllWordsListByLetter()  {



        ArrayList<FlashCard> letterAndItsWordsCollection = new  ArrayList<FlashCard>();

            ArrayList<String> allURLsByLetter=getAllURLByLetter();



            for(String letterURL:allURLsByLetter){


                try {

                Document doc = Jsoup.connect(letterURL).get();

                  ArrayList<FlashCard> letterWords= ParsePageForWords.getWordsList(doc);
                  letterAndItsWordsCollection.addAll(letterWords);

             }catch (Exception e) {

                    e.printStackTrace();
                }


        }
        return letterAndItsWordsCollection;

    }


    public  ArrayList<String> getAllURLByLetter(){

        ArrayList<String> listOfAllURL=new ArrayList<String>();


        for (int i=1;i<=202;i++) {

            String letterURL = DOMAIN_NAME+i+"/" ;


            listOfAllURL.add(letterURL);
        }

        return listOfAllURL;
    }





}
