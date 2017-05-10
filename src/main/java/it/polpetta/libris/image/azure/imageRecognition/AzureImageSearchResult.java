package it.polpetta.libris.image.azure.imageRecognition;

import it.polpetta.libris.contract.IQueryBuilder;
import it.polpetta.libris.contract.ISearcher;
import it.polpetta.libris.image.azure.contract.IAzureImageSearchResult;
import it.polpetta.libris.image.google.contract.IGoogleImageSearchResult;
import it.polpetta.libris.image.google.hmtlImageSearch.GoogleImageSearchResult;
import it.polpetta.libris.utils.Coordinates;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by dpolonio on 10/05/17.
 */
//TODO write me mario
public class AzureImageSearchResult implements IAzureImageSearchResult {


    private AzureImageSearchResult() {}

    @Override
    public String toJSONString() {
        return null;
    }

    @Override
    public String dominantColor() {
        return null;
    }

    @Override
    public ArrayList<Float> probabilities() {
        return null;
    }

    // TODO write me mario
    public static class Builder {

        private String bestGuess;

        public Builder () {
            bestGuess = "";
        }

        public AzureImageSearchResult.Builder addBestGuess(String bestGuess) {
            this.bestGuess = bestGuess;
            return this;
        }

        public AzureImageSearchResult getSearchResult() {

            return new AzureImageSearchResult();
        }
    }

}
