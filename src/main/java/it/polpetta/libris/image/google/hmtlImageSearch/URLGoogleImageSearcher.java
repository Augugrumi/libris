package it.polpetta.libris.image.google.hmtlImageSearch;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import it.polpetta.libris.contract.IQueryBuilder;
import it.polpetta.libris.image.contract.AbstractURLImageSearcher;
import it.polpetta.libris.image.contract.IImageQueryBuilder;
import it.polpetta.libris.image.google.contract.IGoogleImageSearchResult;
import it.polpetta.libris.image.google.contract.IGoogleImageSearcher;
import it.polpetta.libris.util.Coordinates;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by zanna on 08/05/17.
 */
public class URLGoogleImageSearcher extends AbstractURLImageSearcher implements IGoogleImageSearcher {

    private static final String googleImageSearch = "https://www.google.com/searchbyimage?&image_url=";
    private static final String userAgentProperty = "User-Agent";
    private static final String userAgentValue =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) " +
                    "Chrome/23.0.1271.97 Safari/537.11";

    private URLGoogleImageSearcher(URL pathToImage, Coordinates location) {
        super(AbstractURLImageSearcher.stringToURL(googleImageSearch + pathToImage.toString()),
                location);
    }

    @Override
    protected URLConnection setConnectionParameters() {
        URLConnection toDownload = null;
        try {
            toDownload = link.openConnection();
            toDownload.setRequestProperty(userAgentProperty, userAgentValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toDownload;
    }

    @Override
    protected IGoogleImageSearchResult parseResult(String response) {
        Document parsedPage = Parser.parse(response, link.toString());

        final Elements body = parsedPage.body().children();

        return new GoogleImageSearchResult.Builder()
                .addBestGuess(retrieveBestGuessFromHTML(body))
                .addLinks(retrieveLinksFromHTML(body))
                .addDescriptions(retrieveDescriptionFromHTML(body))
                .addTitles(retrieveTitleFromHTML(body))
                .addSimilarImages(retrieveSimilarImageFromHTML(body))
                .getSearchResult();
    }

    @Override
    public IGoogleImageSearchResult search() throws IOException {
        return (IGoogleImageSearchResult) super.search();
    }

    private String retrieveBestGuessFromHTML(Elements body) {
        String bestGuessRes;
        Elements bestGuesses = body.select("a._gUb");
        bestGuessRes = bestGuesses.first().text();
        return bestGuessRes;
    }

    private ArrayList<String> retrieveLinksFromHTML(Elements body) {
        ArrayList<String> linkRes = new ArrayList<String>();
        Elements links = body.select("div.g");
        links = links.select("a[href]");
        for (Element link : links){
            if (!link.hasClass("_Fmb ab_button") &&
                    ! link.hasClass("fl") &&
                    ! link.hasClass("bia") &&
                    ! link.hasClass("duf3") &&
                    ! link.hasClass("iu-card-header") &&
                    ! link.hasAttr("data-rtid") &&
                    ! link.hasAttr("data-ved")) {
                String toCheck = link.attr("href");
                if (!linkRes.contains(toCheck)) {
                    linkRes.add(toCheck);
                }

            }
        }
        return linkRes;
    }

    private ArrayList<String> retrieveDescriptionFromHTML(Elements body) {
        ArrayList<String> descRes = new ArrayList<String>();
        Elements descriptions = body.select("span.st");

        for (Element desc : descriptions)
            descRes.add(desc.text());

        return descRes;
    }

    private ArrayList<String> retrieveTitleFromHTML(Elements body) {
        ArrayList<String> titleRes = new ArrayList<String>();
        Elements titles = body.select("h3.r");

        for (Element title : titles)
            titleRes.add(title.text());

        return titleRes;
    }

    private ArrayList<String> retrieveSimilarImageFromHTML(Elements body) {
        ArrayList<String> imageRes = new ArrayList<String>();
        Elements images = body.select("div.rg_meta");

        Gson gson = new Gson();
        JsonObject jsImage;
        String imageUrl;
        for (Element image : images){

            jsImage = gson.fromJson(image.text(), JsonObject.class);
            imageUrl = jsImage.get("ou").getAsString();
            try {
                new URL(imageUrl);
                imageRes.add(imageUrl);
            } catch (MalformedURLException e) {
                printMalformedError(e);
            }
        }
        return imageRes;
    }

    public static class Builder implements IImageQueryBuilder {

        private File photo = null;
        private URL link = null;
        private Coordinates location = null;


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

        public IGoogleImageSearcher build() {
        // TODO remove
        /*IGoogleImageSearcher searcher = null;
        AbstractFactoryMethodSearcher factory;
        IGoogleImageSearchResult res = null;

        // FIXME
        if (link != null) {
            factory = new URLFactoryMethodSearcher(location, link);
            // In order to use IGoogleImageSearcher we should downcast here!
            searcher = factory.makeSearcher();
        } else if (photo != null) {
            // TODO
        }
        else {
            return null; // No link or photo provided
        }

        try {
            res = searcher.search();
        } catch (IOException e) {

            System.err.println("Error while searching the resources");
            e.printStackTrace();
        }

        return res;*/

            return new URLGoogleImageSearcher(link, null);
        }
    }


}