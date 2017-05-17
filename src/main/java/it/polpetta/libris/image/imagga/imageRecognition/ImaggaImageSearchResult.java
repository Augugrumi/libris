package it.polpetta.libris.image.imagga.imageRecognition;

import it.polpetta.libris.image.azure.imageRecognition.AzureImageSearchResult;
import it.polpetta.libris.image.imagga.contract.IImaggaImageSearchResult;

import java.util.ArrayList;

/**
 * Created by federico on 17/05/17.
 */
public class ImaggaImageSearchResult implements IImaggaImageSearchResult {

    private String bestGuess;
    private ArrayList<String> tags;
    private ArrayList<String> otherTags;
    private String description;

    private ImaggaImageSearchResult(
            String bestGuess,
            ArrayList<String> tags,
            ArrayList<String> otherTags,
            String description
    ) {
        this.bestGuess = bestGuess;
        this.tags = tags;
        this.otherTags = otherTags;
        this.description = description;
    }

    // TODO evaluate the possibility to introduce constants instead of using explicitly strings
    @Override
    public String toJSONString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{")
                .append("\"best_guess\":\"")
                .append(bestGuess)
                .append("\",")
                .append("\"tags\":[")
                .append(arrayListToString(tags))
                .append("],")
                .append("\"other_tags\":[")
                .append(arrayListToString(otherTags))
                .append("],")
                .append("\"description\":\"")
                .append(description)
                .append("\"}");
        return builder.toString();
    }

    private String arrayListToString(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append("\"");
            sb.append(arrayList.get(i));
            sb.append("\"");
            if (i != arrayList.size() - 1)
                sb.append(",");
        }
        return sb.toString();
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

    public static class Builder {

        private String bestGuess;
        private ArrayList<String> tags;
        private ArrayList<String> otherTags;
        private String description;

        public Builder () {
            this.bestGuess = "";
            this.tags = new ArrayList<>();
            this.otherTags = new ArrayList<>();
            this.description = "";
        }

        public ImaggaImageSearchResult.Builder addBestGuess(String bestGuess) {
            this.bestGuess = bestGuess;
            return this;
        }

        public ImaggaImageSearchResult.Builder addTags(ArrayList<String> tags) {
            this.tags = tags;
            return this;
        }

        public ImaggaImageSearchResult.Builder addOtherTags(ArrayList<String> otherTags) {
            this.otherTags = otherTags;
            return this;
        }

        public ImaggaImageSearchResult.Builder addDescription(String description) {
            this.description = description;
            return this;
        }

        public ImaggaImageSearchResult build() {
            return new ImaggaImageSearchResult(
                    bestGuess,
                    tags,
                    otherTags,
                    description
            );
        }
    }
}
