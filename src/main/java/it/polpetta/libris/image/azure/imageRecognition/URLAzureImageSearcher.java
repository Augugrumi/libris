package it.polpetta.libris.image.azure.imageRecognition;

import it.polpetta.libris.contract.IQueryBuilder;
import it.polpetta.libris.contract.ISearcher;
import it.polpetta.libris.image.azure.contract.IAzureImageSearchResult;
import it.polpetta.libris.image.azure.contract.IAzureImageSearcher;
import it.polpetta.libris.image.contract.AbstractURLImageSearcher;
import it.polpetta.libris.utils.Coordinates;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by zanna on 09/05/17.
 */
public class URLAzureImageSearcher extends AbstractURLImageSearcher {
    private static final String azureImageSearch =
            "https://westus.api.cognitive.microsoft.com/vision/v1.0/describe";
    private static final String contentTypeAttribute = "Content-Type";
    private static final String contentTypeValue = "application/json";
    private static final String authenticationAttribute = "Ocp-Apim-Subscription-Key";
    private static String subscriptionKey;
    private URL imagePath;

    URLAzureImageSearcher(URL imagePath, Coordinates location) {
        super(stringToURL(azureImageSearch), location);
        this.imagePath = imagePath;
    }

    static void setSubscriptionKey(String key) {
        subscriptionKey = key;
    }

    @Override
    protected URLConnection setConnectionParameters() {
        URL url = stringToURL(azureImageSearch);
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
                OutputStream os = urlConnection.getOutputStream();
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"), true);
                writer.print(link);
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
        // TODO
        return null;
    }

    @Override
    public IAzureImageSearchResult search()  throws IOException {
        return (IAzureImageSearchResult) super.search();
    }

    public class Builder implements IQueryBuilder {

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
            return null;
        }
    }
}
