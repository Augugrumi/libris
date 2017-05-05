package it.polpetta.libris.utils;

import java.util.ArrayList;

/**
 * Created by zanna on 04/05/17.
 */
public class SearchResult {
    private String bestGuess;
    private ArrayList<String> links;
    private ArrayList<String> descriptions;
    private ArrayList<String> titles;
    private ArrayList<String> similarImages;

    private SearchResult(){}

    public String toJSONString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{")
                .append("\"best_guess\":\"")
                .append(bestGuess)
                .append("\"")
                .append(",")
                .append("\"links\":[")
                .append(arrayListToString(links))
                .append("],")
                .append("\"descriptions\":[")
                .append(arrayListToString(descriptions))
                .append("],")
                .append("\"titles\":[")
                .append(arrayListToString(titles))
                .append("],")
                .append("\"similar_images\":[")
                .append(arrayListToString(similarImages))
                .append("]}");
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

    public static class Builder {
        private String bestGuess;
        private ArrayList<String> links;
        private ArrayList<String> descriptions;
        private ArrayList<String> titles;
        private ArrayList<String> similarImages;

        public Builder() {
            bestGuess = "";
            links = new ArrayList<>();
            descriptions = new ArrayList<>();
            titles = new ArrayList<>();
            similarImages = new ArrayList<>();
        }

        public Builder withBestGuess(String bestGuess) {
            this.bestGuess = bestGuess;
            return this;
        }

        public Builder withLinks(ArrayList<String> links) {
            this.links = links;
            return this;
        }

        public Builder withDescriptions(ArrayList<String> descriptions) {
            this.descriptions = descriptions;
            return this;
        }

        public Builder withTitles(ArrayList<String> titles) {
            this.titles = titles;
            return this;
        }

        public Builder withSimilarImages(ArrayList<String> similarImages) {
            this.similarImages = similarImages;
            return this;
        }

        public SearchResult build() {
            SearchResult result = new SearchResult();
            result.bestGuess = bestGuess;
            result.links = links;
            result.descriptions = descriptions;
            result.titles = titles;
            result.similarImages = similarImages;
            return result;
        }
    }
}
