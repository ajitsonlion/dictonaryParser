package flashcards.vocab.com.germanvocab.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by ajit on 24.11.14.
 */
public class ParserForSentences {

    private   final String URLForSentences="http://dict.tu-chemnitz.de/?;iservice=de-en-ex;query=";



    public void getSentences(FlashCard card){



        try {

            Document doc = Jsoup.connect(URLForSentences+card.getGermanWord()).get();

            Element sentencesTable=doc.getElementById("result");

            Elements tableBody=sentencesTable.getElementsByTag("tbody");

            for (Element e:tableBody){

                Element germanSentence=e.select("td.r.sp").first();

                String germanWordBuilder="";

                Elements individualWords=germanSentence.children();
                for (Element word:individualWords){

                    germanWordBuilder+=" "+word.text();


                }

                germanWordBuilder+=".";




            }







        }catch (Exception e) {

            e.printStackTrace();
        }


    }

}
