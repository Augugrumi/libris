package it.polpetta.libris.image.google.hmtlImageSearch.searchers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import it.polpetta.libris.contract.ISearchResult;
import it.polpetta.libris.image.contract.AbstractURLImageSearcher;
import it.polpetta.libris.image.google.contract.IGoogleImageSearchResult;
import it.polpetta.libris.utils.Coordinates;
import it.polpetta.libris.utils.SearchResult.SearchResultBuilderAbstractFactory;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by zanna on 08/05/17.
 */
public class URLGoogleImageSearcher extends AbstractURLImageSearcher {

    private static final String googleImageSearch = "https://www.google.com/searchbyimage?&image_url=";
    private static final String userAgentProperty = "User-Agent";
    private static final String userAgentValue =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) " +
                    "Chrome/23.0.1271.97 Safari/537.11";

    URLGoogleImageSearcher(URL pathToImage, Coordinates location) {
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
    protected ISearchResult parseResult(String response) {
        Document parsedPage = Parser.parse(response, link.toString());

        Elements body = parsedPage.body().children();

        return SearchResultBuilderAbstractFactory
                .makeGoogleImageSearchBuilder()
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

}