package it.polpetta.libris.utils.SearchResult.googleImageSearch;

import it.polpetta.libris.image.google.contract.IGoogleImageSearchResult;

import java.util.ArrayList;

/**
 * Created by davide on 06/05/17.
 */
public class GoogleImageSearchResultBuilder {

    private String bestGuess;
    private ArrayList<String> links;
    private ArrayList<String> descriptions;
    private ArrayList<String> titles;
    private ArrayList<String> similarImages;

    public GoogleImageSearchResultBuilder() {
        bestGuess = "";
        links = new ArrayList<>();
        descriptions = new ArrayList<>();
        titles = new ArrayList<>();
        similarImages = new ArrayList<>();
    }

    public GoogleImageSearchResultBuilder addBestGuess(String bestGuess) {
        this.bestGuess = bestGuess;
        return this;
    }

    public GoogleImageSearchResultBuilder addLinks(ArrayList<String> links) {
        this.links = links;
        return this;
    }

    public GoogleImageSearchResultBuilder addDescriptions(ArrayList<String> descriptions) {
        this.descriptions = descriptions;
        return this;
    }

    public GoogleImageSearchResultBuilder addTitles(ArrayList<String> titles) {
        this.titles = titles;
        return this;
    }

    public GoogleImageSearchResultBuilder addSimilarImages(ArrayList<String> similarImages) {
        this.similarImages = similarImages;
        return this;
    }

    public IGoogleImageSearchResult getSearchResult() {

        return new GoogleImageSearchResult(
                bestGuess,
                links,
                descriptions,
                titles,
                similarImages
        );
    }
}
