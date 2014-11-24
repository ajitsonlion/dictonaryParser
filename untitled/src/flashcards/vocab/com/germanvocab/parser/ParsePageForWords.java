package flashcards.vocab.com.germanvocab.parser;

import flashcards.vocab.com.germanvocab.MainActivity;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;

/**
 * Created by ajit on 20.11.14.
 */
public class ParsePageForWords {


      static int id = 1;

    public static ArrayList<FlashCard> getWordsList(Document doc) {


        ArrayList<FlashCard> flashCards = new ArrayList<FlashCard>();


        Elements allWords = doc.select("div.thing.text-text");

        for (Element word:allWords){

            FlashCard card=new FlashCard();

            card.setWordId(id++);



            String germanWord=word.select("div.col_a.col.text").text();


            if(germanWord.length()>3){

                String article=germanWord.substring(0,2);
                boolean isArticleExists="der".equalsIgnoreCase(article) || "die".equalsIgnoreCase(article) || "das".equalsIgnoreCase(article);
                if (isArticleExists){

                    card.setArticle(article);
                    card.setGermanWord(germanWord.substring(3));
                    card.setLetter(germanWord.substring(0,0));
                }
                else {

                    card.setArticle("");
                    card.setGermanWord(germanWord);
                    card.setLetter(germanWord.substring(0,0));
                }
            }

            else {


                card.setArticle("");
                card.setGermanWord(germanWord);
                card.setLetter(germanWord.substring(0,0));

            }



            String englishWord=word.select("div.col_b.col.text").text();
            card.setEnglishWord(englishWord);

            flashCards.add(card);

            System.out.println(id);

        }







/*                File f=new File("images"+File.separator+card.getLetter()+File.separator+card.getWordId()+".gif");
                f.getParentFile().mkdirs();

                try {
                    URL urlofImage=new URL(URLConnection.DOMAIN_NAME+imageURL);
                    FileUtils.copyURLToFile(urlofImage, f);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();



            }


        }

       return flashCards;

*/


        return  flashCards;

    }
}
