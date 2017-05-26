package it.polpetta.libris.opticalCharacterRecognition.ocrSpace.freeOcr;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import it.polpetta.libris.contract.IQueryBuilder;
import it.polpetta.libris.contract.ISearchResult;
import it.polpetta.libris.contract.ISearcher;
import it.polpetta.libris.opticalCharacterRecognition.contract.AbstractURLOcr;
import it.polpetta.libris.opticalCharacterRecognition.contract.IOcrQueryBuilder;
import it.polpetta.libris.opticalCharacterRecognition.ocrSpace.contract.IOCRSpaceSearcher;
import it.polpetta.libris.opticalCharacterRecognition.ocrSpace.contract.IOCRSpaceSearchResult;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by davide on 26/05/17.
 */
public class FreeOCRSpaceSearcher extends AbstractURLOcr implements IOCRSpaceSearcher {

    private static String subscriptionKey = null;
    private static String OcrSpaceUrl = "https://api.ocr.space/parse/image";


    private FreeOCRSpaceSearcher (URL link) {
        super(link);
    }

    public static void setSubscriptionKey(String key) {
        subscriptionKey = key;
    }

    @Override
    protected URLConnection setConnectionParameters() {

        HttpsURLConnection connection = null;

        try {
            connection = (HttpsURLConnection) link.openConnection();
            //add request header
            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            connection.setDoOutput(true);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return connection;
    }

    @Override
    protected String retrieveData (URLConnection urlConnection) {

        HttpsURLConnection connection = (HttpsURLConnection) urlConnection;

        JsonObject json = new JsonObject();

        json.addProperty("apikey", subscriptionKey);
        json.addProperty("isOverlayRequired", false);
        json.addProperty("url", link.toString());
        json.addProperty("language", "en");

        try {
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(getPostDataString(json));
            wr.flush();
            wr.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //return result
            return String.valueOf(response);

        } catch (IOException e) {

            System.err.println("Something went wrong with IO");

            e.printStackTrace();
        } catch (Exception e) {

            System.err.println("Something went wrong with 'getPostDataString'");

            e.printStackTrace();
        }

        return null;
    }

    private String getPostDataString(JsonObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<Map.Entry<String, JsonElement>> itr = params.entrySet().iterator();

        while (itr.hasNext()) {

            String key = itr.next().getKey();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }

    @Override
    protected ISearchResult parseResult(String response) {

        System.out.println(response);

        return null;
    }

    @Override
    public IOCRSpaceSearchResult search() throws IOException {
        return (IOCRSpaceSearchResult) super.search();
    }

    public static class Builder implements IOcrQueryBuilder {

        File file = null;
        URL linkToImage = null;

        public Builder () {

        }

        @Override
        public Builder setImage(File file) {
            this.file = file;
            return this;
        }

        @Override
        public Builder setImage(URL linkToImage) {
            this.linkToImage = linkToImage;
            return this;
        }

        @Override
        public FreeOCRSpaceSearcher build() {
            return new FreeOCRSpaceSearcher(
                    linkToImage
            );
        }
    }
}
