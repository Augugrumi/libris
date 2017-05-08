package it.polpetta.libris.azure.characterRecognition;

import it.polpetta.libris.utils.ISearcher;
import it.polpetta.libris.utils.SearchResult;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by dpolonio on 05/05/17.
 */
class URLSearcher implements ISearcher {

    private String subscriptionKey = null;
    private URL imagePath = null;

    URLSearcher(URL imagePath, String subscriptionKey) {
        this.imagePath = imagePath;
        this.subscriptionKey = subscriptionKey;
    }

    public SearchResult search() throws IOException {
        HttpClient httpClient = new DefaultHttpClient();

        try {
            URIBuilder uriBuilder = new URIBuilder("https://westus.api.cognitive.microsoft.com/vision/v1.0/ocr");

            uriBuilder.setParameter("language", "unk");
            uriBuilder.setParameter("detectOrientation ", "true");

            URI uri = uriBuilder.build();
            HttpPost request = new HttpPost(uri);

            // Request headers - replace this example key with your valid subscription key.
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", "4d0d55eba0824d6789ba7d1eb5ef0007");

            // Request body. Replace the example URL with the URL of a JPEG image containing text.
            StringEntity requestEntity = new StringEntity("{\"url\":\"" + imagePath.toString() + "\"}");
            request.setEntity(requestEntity);

            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                System.out.println(EntityUtils.toString(entity));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //TODO when search result will be refactored
        return null;
    }
}
