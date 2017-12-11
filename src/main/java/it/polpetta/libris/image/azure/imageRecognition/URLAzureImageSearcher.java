package com.tfederico.libris.image.azure.imageRecognition;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tfederico.libris.contract.AbstractURLSearcher;
import com.tfederico.libris.image.contract.AbstractURLImageSearcher;
import com.tfederico.libris.contract.IQueryBuilder;
import com.tfederico.libris.image.azure.contract.IAzureImageSearchResult;
import com.tfederico.libris.image.azure.contract.IAzureImageSearcher;
import com.tfederico.libris.util.Coordinates;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by zanna on 09/05/17.
 */
public class URLAzureImageSearcher extends AbstractURLImageSearcher implements IAzureImageSearcher {
    private static final String azureImageSearch =
            "https://westus.api.cognitive.microsoft.com/vision/v1.0/analyze?visualFeatures=Description%2CTags";
    private static final String contentTypeAttribute = "Content-Type";
    private static final String contentTypeValue = "application/json";
    private static final String authenticationAttribute = "Ocp-Apim-Subscription-Key";
    private static String subscriptionKey;
    private URL imagePath;

    private URLAzureImageSearcher(URL imagePath, Coordinates location) {
        super(AbstractURLSearcher.stringToURL(azureImageSearch), location);
        this.imagePath = imagePath;
    }

    public static void setSubscriptionKey(String key) {
        subscriptionKey = key;
    }

    @Override
    protected URLConnection setConnectionParameters() {
        URL url = AbstractURLSearcher.stringToURL(azureImageSearch);
        HttpsURLConnection urlConnection = null;
        try {
            if (url != null) {
                urlConnection = (HttpsURLConnection) url.openConnection();
                urlConnection.addRequestProperty(contentTypeAttribute, contentTypeValue);
                // TODO throws exception if subscription key is null
                urlConnection.addRequestProperty(authenticationAttribute, subscriptionKey);
                urlConnection.setDoOutput(true);
                urlConnection.setDoInput(true);
                urlConnection.connect();
                String json = "{\"url\":\"" + imagePath + "\"}";
                OutputStream os = urlConnection.getOutputStream();
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"), true);
                writer.print(json);
                writer.close();
                os.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return urlConnection;
    }



    @Override
    protected IAzureImageSearchResult parseResult(String response) {
        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(response, JsonObject.class);
        return new AzureImageSearchResult.Builder()
                .addBestGuess(retrieveBestGuessFromJson(jsonResponse))
                .addDescription(retrieveDescriptionFromJson(jsonResponse))
                .addTags(retrieveTagsFromJson(jsonResponse))
                .addOtherTags(retrieveOtherTagsFromJson(jsonResponse))
                .build();
    }

    private String retrieveBestGuessFromJson(JsonObject response) {
        JsonArray tagArray = response.getAsJsonArray("tags");
        float confidence = 0;
        float temp;
        String bestGuess = "";
        for (JsonElement element : tagArray) {
            temp = element.getAsJsonObject().get("confidence").getAsFloat();
            if (temp > confidence) {
                confidence = temp;
                bestGuess = element.getAsJsonObject().get("name").getAsString();
            }
        }
        return bestGuess;
    }

    private String retrieveDescriptionFromJson(JsonObject response) {
        JsonElement element = response.getAsJsonObject("description").getAsJsonArray("captions").get(0);
        String s = element.toString();
        JsonObject obj = new Gson().fromJson(s, JsonObject.class);
        return obj.get("text").getAsString();
    }

    private ArrayList<String> retrieveTagsFromJson(JsonObject response) {
        JsonArray tagArray = response.getAsJsonArray("tags");
        ArrayList<String> tags = new ArrayList<>();
        for (JsonElement element : tagArray)
            tags.add(element.getAsJsonObject().get("name").getAsString());
        return tags;
    }

    private ArrayList<String> retrieveOtherTagsFromJson(JsonObject response) {
        JsonArray tagArray = response.getAsJsonObject("description").getAsJsonArray("tags");
        ArrayList<String> tags = new ArrayList<>();
        for (JsonElement element : tagArray)
            tags.add("" + element.getAsString());
        return tags;
    }

    @Override
    public IAzureImageSearchResult search()  throws IOException {
        return (IAzureImageSearchResult) super.search();
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
        public IAzureImageSearcher build() {
            return new URLAzureImageSearcher(link, null);
        }
    }
}
