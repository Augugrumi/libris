package it.polpetta.libris.opticalCharacterRecognition.ibm.characterRecognition;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import it.polpetta.libris.contract.IQueryBuilder;
import it.polpetta.libris.opticalCharacterRecognition.contract.AbstractURLOcr;
import it.polpetta.libris.opticalCharacterRecognition.ibm.contract.IIBMOcrResult;
import it.polpetta.libris.opticalCharacterRecognition.ibm.contract.IIBMOcrSearcher;
import it.polpetta.libris.util.Coordinates;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by dpolonio on 05/05/17.
 * OCR no longer supported
 */
/*public class URLIBMOcrSearcher extends AbstractURLOcr implements IIBMOcrSearcher {
    private static String subscriptionKey = null;

    private RecognizedText response;

    public URLIBMOcrSearcher(URL link) {
        super(link);
    }

    public static void setSubscriptionKey(String key) {
        subscriptionKey = key;
    }

    @Override
    protected URLConnection setConnectionParameters() {
        return null;
    }

    @Override
    protected IIBMOcrResult parseResult(String nullString) {
        ArrayList<String> bestGuess = new ArrayList<>();

        double score;
        double bestScore = 0;

        for (Word word :
                this.response.getImages().get(0).getWords())
            bestGuess.add(word.getWord());

        return new IBMOcrResult.Builder()
                .addBestGuess(bestGuess)
                .addLanguage("unk")
                .build();
    }

    @Override
    public IIBMOcrResult search() throws IOException {
        VisualRecognition service =
                new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20, subscriptionKey);

        VisualRecognitionOptions options = new VisualRecognitionOptions.Builder()
                .url(link.toString())
                .build();
        response = service.recognizeText(options).execute();

        return parseResult("");
    }

    public static class Builder implements IQueryBuilder {

        private File photo = null;
        private URL link = null;
        private Coordinates location = null;

        public Builder(){}

        @Override
        public URLIBMOcrSearcher.Builder setImage(File file) {
            photo = file;
            return this;
        }

        @Override
        public URLIBMOcrSearcher.Builder setImage(URL linkToImage) {
            link = linkToImage;
            return this;
        }

        @Override
        public URLIBMOcrSearcher build() {
            return new URLIBMOcrSearcher(link);
        }
    }
}*/
