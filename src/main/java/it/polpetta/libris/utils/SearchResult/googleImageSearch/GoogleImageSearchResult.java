package it.polpetta.libris.utils.SearchResult.googleImageSearch;

import it.polpetta.libris.image.google.contract.IGoogleImageSearchResult;

import java.util.ArrayList;

/**
 * Created by davide on 06/05/17.
 */
class GoogleImageSearchResult implements IGoogleImageSearchResult {

    private String bestGuess;
    private ArrayList<String> links;
    private ArrayList<String> descriptions;
    private ArrayList<String> titles;
    private ArrayList<String> similarImages;

    GoogleImageSearchResult(
            String bestGuess,
            ArrayList<String> links,
            ArrayList<String> descriptions,
            ArrayList<String> titles,
            ArrayList<String> similarImages
            ) {

        this.bestGuess = bestGuess;
        this.links = links;
        this.descriptions = descriptions;
        this.titles = titles;
        this.similarImages = similarImages;
    }

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

    public String getBestGuess() {
        return bestGuess;
    }

    public ArrayList<String> getTags() {

        ArrayList<String> res = new ArrayList<String>();
        res.add(getBestGuess());

        return res;
    }

    public ArrayList<String> getLinks() {
        return links;
    }

    public ArrayList<String> getDescription() {
        return descriptions;
    }

    public ArrayList<String> getTitles() {
        return titles;
    }

    public ArrayList<String> getSimilarImages() {
        return similarImages;
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
}
