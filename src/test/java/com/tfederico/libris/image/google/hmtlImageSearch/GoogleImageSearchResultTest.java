package com.tfederico.libris.image.google.hmtlImageSearch;

import com.tfederico.libris.image.google.contract.IGoogleImageSearchResult;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by zanna on 11/05/17.
 */
public class GoogleImageSearchResultTest extends TestCase{

    private static final String bestGuess = "best_guess";
    private static final ArrayList<String> array = new ArrayList<>();
    private static final String arrayToString = "\"first\",\"second\",\"third\"";

    static {
        array.add("first");
        array.add("second");
        array.add("third");
    }

    private IGoogleImageSearchResult res = new GoogleImageSearchResult.Builder()
            .addBestGuess(bestGuess)
            .addDescriptions(array)
            .addLinks(array)
            .addSimilarImages(array)
            .addTitles(array)
            .build();


    @Test
    public void testToJSONString() throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append("{")
                .append("\"best_guess\":\"")
                .append(bestGuess)
                .append("\"")
                .append(",")
                .append("\"links\":[")
                .append(arrayToString)
                .append("],")
                .append("\"descriptions\":[")
                .append(arrayToString)
                .append("],")
                .append("\"titles\":[")
                .append(arrayToString)
                .append("],")
                .append("\"similar_images\":[")
                .append(arrayToString)
                .append("]}");
        Assert.assertEquals(builder.toString(), res.toJSONString());
    }

    @Test
    public void testGetBestGuess() throws Exception {
        Assert.assertEquals(bestGuess, res.getBestGuess());
    }

    @Test
    public void testGetTags() throws Exception {
        Assert.assertEquals(bestGuess, res.getTags().get(0));
    }

    @Test
    public void testGetLinks() throws Exception {
        for(int i = 0; i < array.size(); i++)
            Assert.assertEquals(array.get(i), res.getLinks().get(i));
    }

    @Test
    public void testGetDescription() throws Exception {
        for(int i = 0; i < array.size(); i++)
            Assert.assertEquals(array.get(i), res.getDescription().get(i));
    }

    @Test
    public void testGetTitles() throws Exception {
        for(int i = 0; i < array.size(); i++)
            Assert.assertEquals(array.get(i), res.getTitles().get(i));
    }

    @Test
    public void testGetSimilarImages() throws Exception {
        for(int i = 0; i < array.size(); i++)
            Assert.assertEquals(array.get(i), res.getSimilarImages().get(i));
    }
}