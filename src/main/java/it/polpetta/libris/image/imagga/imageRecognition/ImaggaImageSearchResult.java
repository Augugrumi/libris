package com.tfederico.libris.image.imagga.imageRecognition;

import com.tfederico.libris.image.imagga.contract.IImaggaImageSearchResult;

import java.util.ArrayList;

/**
 * Created by federico on 17/05/17.
 */
public class ImaggaImageSearchResult implements IImaggaImageSearchResult {

    private String bestGuess;
    private ArrayList<String> tags;
    private ArrayList<String> otherTags;

    private ImaggaImageSearchResult(
            String bestGuess,
            ArrayList<String> tags,
            ArrayList<String> otherTags
    ) {
        this.bestGuess = bestGuess;
        this.tags = tags;
        this.otherTags = otherTags;
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

    public static class Builder {

        private String bestGuess;
        private ArrayList<String> tags;
        private ArrayList<String> otherTags;

        public Builder () {
            this.bestGuess = "";
            this.tags = new ArrayList<>();
            this.otherTags = new ArrayList<>();
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

        public ImaggaImageSearchResult build() {
            return new ImaggaImageSearchResult(
                    bestGuess,
                    tags,
                    otherTags
            );
        }
    }
}
