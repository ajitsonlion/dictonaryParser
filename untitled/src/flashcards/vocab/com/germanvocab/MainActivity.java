package flashcards.vocab.com.germanvocab;



import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import flashcards.vocab.com.germanvocab.parser.URLConnectorForWords;
import flashcards.vocab.com.germanvocab.parser.FlashCard;



public class MainActivity {


    private static ArrayList<FlashCard> wordsDatabase=new ArrayList<FlashCard>();


    public static void main( final String[] args ){


        URLConnectorForWords connector = new URLConnectorForWords();
        wordsDatabase = connector.getAllWordsListByLetter();

        Gson gson = new Gson();



        FileWriter fileWriter = null;
        try {
            String content = gson.toJson(wordsDatabase);
            File newTextFile = new File("./dictionary.json");
            fileWriter = new FileWriter(newTextFile);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



    }

}




