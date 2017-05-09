package it.polpetta.libris.image.azure;

import it.polpetta.libris.contract.ISearchResult;
import it.polpetta.libris.image.azure.contract.IAzureImageSearchResult;
import it.polpetta.libris.image.contract.AbstractURLImageSearcher;
import it.polpetta.libris.utils.Coordinates;
import org.apache.http.util.Asserts;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by zanna on 09/05/17.
 */
public class AzureImageSearcher extends AbstractURLImageSearcher {
    private static final String azureImageSearch =
            "https://westus.api.cognitive.microsoft.com/vision/v1.0/describe";
    private static final String contentTypeAttribute = "Content-Type";
    private static final String contentTypeValue = "application/json";
    private static final String authenticationAttribute = "Ocp-Apim-Subscription-Key";
    private static String subscriptionKey;
    private URL imagePath;

    AzureImageSearcher(URL imagePath, Coordinates location) {
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
    public IAzureImageSearchResult search()  throws IOException {
        return (IAzureImageSearchResult) super.search();
    }

    @Override
    protected IAzureImageSearchResult parseResult(String response) {
        // TODO
        return null;
    }
}
