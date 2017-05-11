package it.polpetta.libris.opticalCharacterRecognition.azure.characterRecognition;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import it.polpetta.libris.contract.IQueryBuilder;
import it.polpetta.libris.contract.ISearcher;
import it.polpetta.libris.image.azure.contract.IAzureImageSearchResult;
import it.polpetta.libris.image.azure.contract.IAzureImageSearcher;
import it.polpetta.libris.image.azure.imageRecognition.AzureImageSearchResult;
import it.polpetta.libris.image.contract.AbstractURLImageSearcher;
import it.polpetta.libris.opticalCharacterRecognition.azure.contract.IAzureOcrResult;
import it.polpetta.libris.opticalCharacterRecognition.azure.contract.IAzureOcrSearcher;
import it.polpetta.libris.opticalCharacterRecognition.contract.AbstractURLOcr;
import it.polpetta.libris.opticalCharacterRecognition.contract.IOcrQueryBuilder;
import it.polpetta.libris.util.Coordinates;

import javax.naming.directory.SearchResult;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by dpolonio on 05/05/17.
 */
public class URLAzureOcrSearcher extends AbstractURLOcr implements IAzureOcrSearcher{
    private static final String azureOCRSearch =
            "https://westus.api.cognitive.microsoft.com/vision/v1.0/ocr?language=unk&detectOrientation=true";
    private static final String contentTypeAttribute = "Content-Type";
    private static final String contentTypeValue = "application/json";
    private static final String authenticationAttribute = "Ocp-Apim-Subscription-Key";
    private static String subscriptionKey;
    private URL imagePath;

    private URLAzureOcrSearcher(URL imagePath, Coordinates location) {
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
        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(response, JsonObject.class);
        return null;
    }

    @Override
    public IAzureOcrResult search()  throws IOException {
        return (IAzureOcrResult) super.search();
    }


    public static class Builder implements IOcrQueryBuilder {

        @Override
        public Builder setImage(File file) {
            return null;
        }

        @Override
        public Builder setImage(URL linkToImage) {
            return null;
        }

        @Override
        public IAzureOcrSearcher build() {
            return null;
        }

    }
}
