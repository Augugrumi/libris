package it.polpetta.libris.opticalCharacterRecognition.azure.characterRecognition;

import it.polpetta.libris.opticalCharacterRecognition.azure.contract.IAzureOcrResult;

import java.util.ArrayList;

/**
 * Created by dpolonio on 10/05/17.
 */
public class AzureOcrResult implements IAzureOcrResult {

    private ArrayList<String> bestGuess;
    private String language;

    private AzureOcrResult(
            ArrayList<String> bestGuess,
            String language
    ) {
        this.bestGuess = bestGuess;
        this.language = language;
    }

    // TODO evaluate the possibility to introduce constants instead of using explicitly strings
    @Override
    public String toJSONString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{")
                .append("\"best_guess\":\"")
                .append(bestGuess)
                .append("\",")
                .append("\"language\":\"")
                .append(language)
                .append("\"}");
        return builder.toString();
    }

    @Override
    public ArrayList<String> getBestGuess() {
        return bestGuess;
    }

    @Override
    public String getLanguage() {
        return language;
    }


    public static class Builder {

        private String language;
        private ArrayList<String> bestGuess;

        public Builder () {
            language = "";
        }

        public Builder addLanguage(String language) {
            this.language = language;
            return this;
        }

        public Builder addBestGuess(ArrayList<String> bestGuess) {
            this.bestGuess = bestGuess;
            return this;
        }

        public IAzureOcrResult build() {
            return new AzureOcrResult(bestGuess, language);
        }
    }

}
