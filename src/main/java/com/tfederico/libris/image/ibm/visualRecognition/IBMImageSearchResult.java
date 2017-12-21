package com.tfederico.libris.image.ibm.visualRecognition;

import com.tfederico.libris.image.ibm.contract.IIBMImageSearchResult;

import java.util.ArrayList;

/**
 * Created by dpolonio on 10/05/17.
 */
public class IBMImageSearchResult implements IIBMImageSearchResult {

    private String bestGuess;
    private ArrayList<String> tags;

    private IBMImageSearchResult(
            String bestGuess,
            ArrayList<String> tags
    ) {
        this.bestGuess = bestGuess;
        this.tags = tags;
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

    @Override
    public String getBestGuess() {
        return bestGuess;
    }

    @Override
    public ArrayList<String> getTags() {
        return tags;
    }


    public static class Builder {

        private String bestGuess;
        private ArrayList<String> tags;

        public Builder () {
            this.bestGuess = "";
            this.tags = new ArrayList<>();
        }

        public IBMImageSearchResult.Builder addBestGuess(String bestGuess) {
            this.bestGuess = bestGuess;
            return this;
        }

        public IBMImageSearchResult.Builder addTags(ArrayList<String> tags) {
            this.tags = tags;
            return this;
        }

        public IBMImageSearchResult build() {
            return new IBMImageSearchResult(
                    bestGuess,
                    tags
            );
        }
    }

}
