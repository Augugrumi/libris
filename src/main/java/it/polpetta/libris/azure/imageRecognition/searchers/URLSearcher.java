package it.polpetta.libris.azure.imageRecognition.searchers;

import it.polpetta.libris.utils.ISearcher;
import it.polpetta.libris.utils.SearchResult;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by dpolonio on 05/05/17.
 */
class URLSearcher implements ISearcher {

    private String subscriptionKey = null;

    URLSearcher(String subscriptionKey) {
        this.subscriptionKey = subscriptionKey;
    }

    public SearchResult search() throws IOException {
        HttpClient httpclient = new DefaultHttpClient();
        SearchResult res = null;

        try {
            URIBuilder builder = new URIBuilder("https://westus.api.cognitive.microsoft.com/vision/v1.0/describe");

            builder.setParameter("visualFeatures", "Categories");
            builder.setParameter("details", "Celebrities");
            builder.setParameter("language", "en");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);

            // Request headers - replace this example key with your valid subscription key.
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);

            // Request body. Replace the example URL with the URL for the JPEG image of a celebrity.
            StringEntity reqEntity = new StringEntity("{\"url\":\"http://example.com/images/test.jpg\"}");
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) {

                // TODO create the SearchResult to return.

                System.out.println(EntityUtils.toString(entity));
            }

        } catch (URISyntaxException e) {

            System.err.println("Error while parsing URIs!");
            e.printStackTrace();
        }

        return res;
    }
}
