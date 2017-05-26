package it.polpetta.libris.opticalCharacterRecognition.ocrSpace.freeOcr;

import it.polpetta.libris.opticalCharacterRecognition.ocrSpace.contract.IOCRSpaceSearchResult;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by davide on 26/05/17.
 */
public class FreeOcrResultTest extends TestCase {


    private static final ArrayList<String> bestGuess = new ArrayList<>();

    static {
        bestGuess.add("one");
        bestGuess.add("two");
        bestGuess.add("three");
    }

    private IOCRSpaceSearchResult res = new FreeOCRSpaceResult.Builder()
            .addBestGuess(bestGuess)
            .build();

    @Test
    public void testToJSONString() throws Exception {

        StringBuilder builder = new StringBuilder();
        builder.append("{")
                .append("\"best_guess\":\"")
                .append(bestGuess)
                .append("\"}");
        Assert.assertEquals(builder.toString(), res.toJSONString());
    }

    @Test
    public void testGetBestGuess() throws Exception {
        for(int i = 0; i < bestGuess.size(); i++)
            Assert.assertEquals(bestGuess.get(i), res.getBestGuess().get(i));
    }
}
