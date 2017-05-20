package it.polpetta.libris.image.ibm.visualRecognition;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.*;
import it.polpetta.libris.contract.AbstractURLSearcher;
import it.polpetta.libris.contract.IQueryBuilder;
import it.polpetta.libris.image.azure.contract.IAzureImageSearcher;
import it.polpetta.libris.image.azure.imageRecognition.URLAzureImageSearcher;
import it.polpetta.libris.image.ibm.contract.IIBMImageSearcher;
import it.polpetta.libris.image.ibm.contract.IIBMImageSearchResult;
import it.polpetta.libris.util.Coordinates;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by dpolonio on 17/05/17.
 */
public class URLIBMImageSearcher extends AbstractURLSearcher implements IIBMImageSearcher {

    private static String subscriptionKey = null;

    private VisualClassification response;

    public URLIBMImageSearcher (URL link) {
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
    protected IIBMImageSearchResult parseResult(String nullString) {
        String bestGuess = null;
        ArrayList<String> tags = new ArrayList<>();

        double score;
        double bestScore = 0;
        for (VisualClassifier classifier :
                this.response.getImages().get(0).getClassifiers()) {
            for (VisualClassifier.VisualClass visualClass : classifier.getClasses()) {
                score = visualClass.getScore();
                if (score > bestScore) {
                    if (bestGuess != null)
                        tags.add(bestGuess);
                    bestGuess = visualClass.getName();
                    bestScore = score;
                } else
                    tags.add(visualClass.getName());
            }
        }

        return new IBMImageSearchResult.Builder()
                .addBestGuess(bestGuess)
                .addTags(tags)
                .build();
    }

    @Override
    public IIBMImageSearchResult search() throws IOException {
        VisualRecognition service =
                new VisualRecognition("2017-05-18T19:50Z", subscriptionKey);

        ClassifyImagesOptions options1 = new ClassifyImagesOptions.Builder()
                .url(link.toString())
                .build();
        response = service.classify(options1).execute();

        return parseResult("");
    }

    public static class Builder implements IQueryBuilder {

        private File photo = null;
        private URL link = null;
        private Coordinates location = null;

        public Builder(){}

        public URLIBMImageSearcher.Builder setLocation(float x, float y) {
            location = new Coordinates(x, y);
            return this;
        }

        @Override
        public URLIBMImageSearcher.Builder setImage(File file) {
            photo = file;
            return this;
        }

        @Override
        public URLIBMImageSearcher.Builder setImage(URL linkToImage) {
            link = linkToImage;
            return this;
        }

        @Override
        public URLIBMImageSearcher build() {
            return new URLIBMImageSearcher(link);
        }
    }
}
