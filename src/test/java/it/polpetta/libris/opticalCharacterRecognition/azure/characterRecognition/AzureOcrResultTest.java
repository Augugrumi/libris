package it.polpetta.libris.opticalCharacterRecognition.azure.characterRecognition;

import it.polpetta.libris.opticalCharacterRecognition.azure.contract.IAzureOcrResult;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by davide on 12/05/17.
 */
public class AzureOcrResultTest {

    private static final String bestGuess = "something";
    private static final String language = "a beautiful language";

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
        Assert.assertEquals(bestGuess, res.getBestGuess());
    }


    @Test
    public void testLanguage() throws Exception {
        Assert.assertEquals(language, res.getLanguage());
    }
}
