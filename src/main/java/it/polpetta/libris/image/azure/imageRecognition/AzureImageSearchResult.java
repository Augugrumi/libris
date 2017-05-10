package it.polpetta.libris.image.azure.imageRecognition;

import it.polpetta.libris.image.azure.contract.IAzureImageSearchResult;

import java.util.ArrayList;

/**
 * Created by dpolonio on 10/05/17.
 */
//TODO write me mario
public class AzureImageSearchResult implements IAzureImageSearchResult {

    private String bestGuess;
    private ArrayList<String> tags;
    private ArrayList<String> otherTags;
    private String description;

    private AzureImageSearchResult() {}

    @Override
    public String toJSONString() {
        return null;
    }

    @Override
    public String getBestGuess() {
        return bestGuess;
    }

    @Override
    public ArrayList<String> getTags() {
        return tags;
    }

    @Override
    public ArrayList<String> getOtherTags() {
        return otherTags;
    }

    @Override
    public String getDescription() {
        return description;
    }

    // TODO write me mario
    public static class Builder {

        private String bestGuess;
        private ArrayList<String> tags;
        private ArrayList<String> otherTags;
        private String description;

        public Builder () {
            bestGuess = "";
            tags = new ArrayList<>();
            otherTags = new ArrayList<>();
            description = "";
        }

        public AzureImageSearchResult.Builder addBestGuess(String bestGuess) {
            this.bestGuess = bestGuess;
            return this;
        }

        public AzureImageSearchResult.Builder addTags(ArrayList<String> tags) {
            this.tags = tags;
            return this;
        }

        public AzureImageSearchResult.Builder addOtherTags(ArrayList<String> otherTags) {
            this.otherTags = otherTags;
            return this;
        }

        public AzureImageSearchResult.Builder addDescription(String description) {
            this.description = description;
            return this;
        }

        public AzureImageSearchResult build() {
            return new AzureImageSearchResult();
        }
    }

}
