package it.polpetta.libris.google.imageSearch.searchers;

import it.polpetta.libris.google.imageSearch.Coordinates;
import org.json.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by davide on 28/04/17.
 */
class URLSearcher implements ISearcher {

    private URL link = null;
    private Coordinates location = null;


    URLSearcher (URL pathToImage, Coordinates location) {

        final String googleImageSearch = "https://www.google.com/searchbyimage?&image_url=";

        try {
            this.link = new URL( googleImageSearch + pathToImage.toString());

        } catch (MalformedURLException e) {

            System.err.println("The URL provided it's not correct!");
            e.printStackTrace();
        }
        this.location = location;
    }

    public JSONObject search() throws IOException {

        URLConnection toDownload = link.openConnection();
        toDownload.setRequestProperty(
                "User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) " +
                "Chrome/23.0.1271.97 Safari/537.11"
        );

        BufferedReader in = new BufferedReader(new InputStreamReader(toDownload.getInputStream()));

        String htmlPage= "";
        boolean iterate = true;

        while (iterate) {
            String nextLine = in.readLine();

            if (nextLine == null) {
                iterate = false;
            } else {
                htmlPage = htmlPage + (nextLine + '\n');
            }
        }

        // TODO parse the HTML page

        return null;
    }
}
