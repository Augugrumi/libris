package com.tfederico.libris.opticalCharacterRecognition.azure.characterRecognition;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tfederico.libris.opticalCharacterRecognition.azure.contract.IAzureOcrResult;
import com.tfederico.libris.opticalCharacterRecognition.azure.contract.IAzureOcrSearcher;
import com.tfederico.libris.opticalCharacterRecognition.contract.AbstractURLOcr;
import com.tfederico.libris.opticalCharacterRecognition.contract.IOcrQueryBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by dpolonio on 05/05/17.
 */
public class URLAzureOcrSearcher extends AbstractURLOcr implements IAzureOcrSearcher {
    private static final String azureOCRSearch =
            "https://westus.api.cognitive.microsoft.com/vision/v1.0/ocr?language=unk&detectOrientation=true";
    private static final String contentTypeAttribute = "Content-Type";
    private static final String contentTypeValue = "application/json";
    private static final String authenticationAttribute = "Ocp-Apim-Subscription-Key";
    private static String subscriptionKey;
    private URL imagePath;

    private URLAzureOcrSearcher(URL imagePath) {
        super(stringToURL(azureOCRSearch));
        this.imagePath = imagePath;
    }

    public static void setSubscriptionKey(String key) {
        subscriptionKey = key;
    }

    @Override
    protected URLConnection setConnectionParameters() {
        URL url = stringToURL(azureOCRSearch);
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
    protected IAzureOcrResult parseResult(String response) {
        ArrayList<String> res = new ArrayList<>();
        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(response, JsonObject.class);
        String language = jsonResponse.get("language").getAsString();

        JsonArray regions = jsonResponse.get("regions").getAsJsonArray();

        for (JsonElement region : regions){
            JsonArray lines = region.getAsJsonObject().get("lines").getAsJsonArray();
            StringBuilder phrase = new StringBuilder();

            for (JsonElement line : lines) {
                JsonArray words = line.getAsJsonObject().get("words").getAsJsonArray();

                for (JsonElement word : words) {
                    String text = word.getAsJsonObject().get("text").getAsString();
                    phrase.append(text);
                    phrase.append(" ");
                }
            }

            phrase.deleteCharAt(phrase.length() - 1);
            res.add(phrase.toString());
        }


        return new AzureOcrResult.Builder()
                .addBestGuess(res)
                .addLanguage(language)
                .build();
    }

    @Override
    public IAzureOcrResult search()  throws IOException {
        return (IAzureOcrResult) super.search();
    }


    public static class Builder implements IOcrQueryBuilder {

        private File file;
        private URL url;

        public Builder() {}

        @Override
        public Builder setImage(File file) {
            this.file = file;
            return this;
        }

        @Override
        public Builder setImage(URL linkToImage) {
            this.url = linkToImage;
            return this;
        }

        @Override
        public IAzureOcrSearcher build() {
            return new URLAzureOcrSearcher(url);
        }

    }
}
