package it.polpetta.libris.opticalCharacterRecognition.azure.characterRecognition;

import it.polpetta.libris.opticalCharacterRecognition.azure.contract.IAzureOcrResult;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by davide on 12/05/17.
 */
public class AzureOcrResultTest extends TestCase {

    //private static final String bestGuess = "something";
    private static final ArrayList<String> bestGuess = new ArrayList<>();
    private static final String language = "a beautiful language";

    static {
        bestGuess.add("one");
        bestGuess.add("two");
        bestGuess.add("three");
    }

    private IAzureOcrResult res = new AzureOcrResult
            .Builder()
            .addBestGuess(bestGuess)
            .addLanguage(language)
            .build();

    @Test
    public void testToJSONString() throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append("{")
                .append("\"best_guess\":\"")
                .append(bestGuess)
                .append("\",")
                .append("\"language\":\"")
                .append(language)
                .append("\"}");
        Assert.assertEquals(builder.toString(), res.toJSONString());
    }

    @Test
    public void testGetBestGuess() throws Exception {
        for(int i = 0; i < bestGuess.size(); i++)
            Assert.assertEquals(bestGuess.get(i), res.getBestGuess().get(i));
    }


    @Test
    public void testLanguage() throws Exception {
        Assert.assertEquals(language, res.getLanguage());
    }
}
