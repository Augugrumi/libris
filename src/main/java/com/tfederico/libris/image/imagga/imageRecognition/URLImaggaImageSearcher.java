package com.tfederico.libris.image.imagga.imageRecognition;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tfederico.libris.image.imagga.contract.IImaggaImageSearcher;
import com.tfederico.libris.contract.IQueryBuilder;
import com.tfederico.libris.contract.ISearchResult;
import com.tfederico.libris.image.contract.AbstractURLImageSearcher;
import com.tfederico.libris.image.imagga.contract.IImaggaImageSearchResult;
import com.tfederico.libris.util.Coordinates;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.apache.commons.codec.binary.Base64;

/**
 * Created by federico on 17/05/17.
 */
public class URLImaggaImageSearcher extends AbstractURLImageSearcher implements IImaggaImageSearcher {

    private static final String imaggaImageSearch =
            "https://api.imagga.com/v1/tagging";
    private static final String contentTypeAttribute = "Accept";
    private static final String contentTypeValue = "application/json";
    private static final String authenticationAttribute = "Authorization";
    private static final String authenticationType = "Basic ";
    private static String subscriptionKey;
    private URL link;
    private static final double limit = 35;

    private URLImaggaImageSearcher(URL link, Coordinates location) {
        super(link, location);
        this.link = link;
    }

    public static void setSubscriptionKey(String key) {
        subscriptionKey = key;
    }

    @Override
    protected URLConnection setConnectionParameters() {
        URL url = stringToURL(imaggaImageSearch + "?" +
            "url=" + link);
        HttpsURLConnection urlConnection = null;
        try {
            if (url != null) {
                urlConnection = (HttpsURLConnection)url.openConnection();
                // TODO throws exception if subscription key is null
                String basicAuth = authenticationType +
                        new String(new Base64().encode(subscriptionKey.getBytes()));
                urlConnection.addRequestProperty (authenticationAttribute, basicAuth);
                urlConnection.addRequestProperty(contentTypeAttribute, contentTypeValue);
                urlConnection.connect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return urlConnection;
    }

    @Override
    protected ISearchResult parseResult(String response) {
        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(response, JsonObject.class);

        return new ImaggaImageSearchResult.Builder()
                .addBestGuess(retrieveBestGuessFromJson(jsonResponse))
                .addTags(retrieveTagsFromJson(jsonResponse))
                .addOtherTags(retrieveOtherTagsFromJson(jsonResponse))
                .build();
    }

    private String retrieveBestGuessFromJson(JsonObject response) {
        JsonArray tagArray = response
                .getAsJsonArray("results")
                .get(0)
                .getAsJsonObject()
                .getAsJsonArray("tags");
        float confidence = 0;
        float temp;
        String bestGuess = "";
        for (JsonElement element : tagArray) {
            temp = element.getAsJsonObject().get("confidence").getAsFloat();
            if (temp > confidence) {
                confidence = temp;
                bestGuess = element.getAsJsonObject().get("tag").getAsString();
            }
        }
        return bestGuess;
    }

    private ArrayList<String> retrieveTagsFromJson(JsonObject response) {
        JsonArray tagArray = response
                .getAsJsonArray("results")
                .get(0)
                .getAsJsonObject()
                .getAsJsonArray("tags");
        ArrayList<String> tags = new ArrayList<>();
        double confidence = 0;
        for (JsonElement element : tagArray) {
            confidence = element.getAsJsonObject().get("confidence").getAsDouble();
            if (confidence >= limit)
                tags.add(element.getAsJsonObject().get("tag").getAsString());
        }
        return tags;
    }

    private ArrayList<String> retrieveOtherTagsFromJson(JsonObject response) {
        JsonArray tagArray = response
                .getAsJsonArray("results")
                .get(0)
                .getAsJsonObject()
                .getAsJsonArray("tags");
        ArrayList<String> tags = new ArrayList<>();
        double confidence = 0;
        for (JsonElement element : tagArray) {
            confidence = element.getAsJsonObject().get("confidence").getAsDouble();
            if (confidence < limit)
                tags.add(element.getAsJsonObject().get("tag").getAsString());
        }
        return tags;
    }

    @Override
    public IImaggaImageSearchResult search()  throws IOException {
        return (IImaggaImageSearchResult) super.search();
    }

    public static class Builder implements IQueryBuilder {

        private File photo = null;
        private URL link = null;
        private Coordinates location = null;

        public Builder(){}

        public Builder setLocation(float x, float y) {
            location = new Coordinates(x, y);
            return this;
        }

        @Override
        public Builder setImage(File file) {
            photo = file;
            return this;
        }

        @Override
        public Builder setImage(URL linkToImage) {
            link = linkToImage;
            return this;
        }

        @Override
        public IImaggaImageSearcher build() {
            return new URLImaggaImageSearcher(link, null);
        }
    }
}
