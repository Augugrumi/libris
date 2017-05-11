package it.polpetta.libris.image.azure.imageRecognition;

import it.polpetta.libris.image.azure.contract.IAzureImageSearchResult;
import it.polpetta.libris.image.google.contract.IGoogleImageSearchResult;
import it.polpetta.libris.image.google.hmtlImageSearch.GoogleImageSearchResult;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by zanna on 11/05/17.
 */
public class AzureImageSearchResultTest {

    private static final String bestGuess = "best_guess";
    private static final String description = "description";
    private static final ArrayList<String> array = new ArrayList<>();
    private static final String arrayToString = "\"first\",\"second\",\"third\"";

    static {
        array.add("first");
        array.add("second");
        array.add("third");
    }

    private IAzureImageSearchResult res = new AzureImageSearchResult
            .Builder()
            .addBestGuess(bestGuess)
            .addDescription(description)
            .addTags(array)
            .addOtherTags(array)
            .build();

    @Test
    public void testToJSONString() throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append("{")
                .append("\"best_guess\":\"")
                .append(bestGuess)
                .append("\",")
                .append("\"tags\":[")
                .append(arrayToString)
                .append("],")
                .append("\"other_tags\":[")
                .append(arrayToString)
                .append("],")
                .append("\"description\":\"")
                .append(description)
                .append("\"}");
        Assert.assertEquals(builder.toString(), res.toJSONString());
    }

    @Test
    public void testGetBestGuess() throws Exception {
        Assert.assertEquals(bestGuess, res.getBestGuess());
    }

    @Test
    public void testGetTags() throws Exception {
        for(int i = 0; i < array.size(); i++)
            Assert.assertEquals(array.get(i), res.getTags().get(i));
    }

    @Test
    public void testGetOtherTags() throws Exception {
        for(int i = 0; i < array.size(); i++)
            Assert.assertEquals(array.get(i), res.getOtherTags().get(i));
    }

    @Test
    public void testGetDescription() throws Exception {
        Assert.assertEquals(description, res.getDescription());
    }
}