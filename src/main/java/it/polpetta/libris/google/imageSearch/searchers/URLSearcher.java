package it.polpetta.libris.google.imageSearch.searchers;

import it.polpetta.libris.google.imageSearch.Coordinates;
import org.json.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

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

        JSONObject res = new JSONObject();

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
                htmlPage += nextLine;
            }
        }

        // TODO parse the HTML page
        Document parsedPage = Parser.parse(htmlPage, link.toString());

        Elements body = parsedPage.body().children();


        // LINKS
        Elements links = body.select("div");
        ArrayList<String> linkRes = new ArrayList<String>();

        for (Element link : links) {

            Elements gDiv = link.getElementsByClass("g");

            for (Element singleLink : gDiv) {

                Elements gDivLink = singleLink.select("a[href]");

                for (Element uniqueLink : gDivLink) {

                    uniqueLink.empty();
                    if (!uniqueLink.hasClass("_Fmb ab_button") &&
                            ! uniqueLink.hasClass("fl") &&
                            ! uniqueLink.hasClass("bia") &&
                            ! uniqueLink.hasClass("duf3") &&
                            ! uniqueLink.hasClass("iu-card-header") &&
                            ! uniqueLink.hasAttr("data-rtid") &&
                            ! uniqueLink.hasAttr("data-ved")) {
                        String toCheck = uniqueLink.attr("href");
                        if (!linkRes.contains(toCheck)) {
                            linkRes.add(toCheck);
                        }

                    }

                }
            }

        }

        res.put("links", linkRes);

        // END LINKS

        // DESCRIPTIONS

        // END DESCRIPTIONS

        return res;
    }
}
