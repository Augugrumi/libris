package it.polpetta.libris.opticalCharacterRecognition.ocrSpace.freeOcr;

import it.polpetta.libris.opticalCharacterRecognition.ocrSpace.contract.IOCRSpaceSearchResult;

import java.util.ArrayList;

/**
 * Created by davide on 26/05/17.
 */
public class FreeOCRSpaceResult implements IOCRSpaceSearchResult {

    private final ArrayList<String> bestGuess;

    private FreeOCRSpaceResult(ArrayList<String> bestGuess) {

        this.bestGuess = bestGuess;
    }

    @Override
    public String toJSONString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{")
                .append("\"best_guess\":\"")
                .append(bestGuess)
                .append("\"}");
        return builder.toString();
    }

    @Override
    public ArrayList<String> getBestGuess() {
        return bestGuess;
    }

    public static class Builder {

        private ArrayList<String> bestGuess;

        public Builder () {
        }

        public Builder addBestGuess(ArrayList<String> bestGuess) {
            this.bestGuess = bestGuess;
            return this;
        }

        public FreeOCRSpaceResult build() {
            return new FreeOCRSpaceResult(bestGuess);
        }
    }
}
