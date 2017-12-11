package com.tfederico.libris.image.ibm.visualRecognition;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.*;
import com.tfederico.libris.contract.AbstractURLSearcher;
import com.tfederico.libris.image.ibm.contract.IIBMImageSearchResult;
import com.tfederico.libris.contract.IQueryBuilder;
import com.tfederico.libris.image.ibm.contract.IIBMImageSearcher;
import com.tfederico.libris.util.Coordinates;

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

    private ClassifiedImages response;

    URLIBMImageSearcher (URL link) {
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
        for (ClassifierResult classifier : this.response.getImages().get(0).getClassifiers()) {
            for (ClassResult visualClass : classifier.getClasses()) {
                score = visualClass.getScore();
                if (score > bestScore) {
                    if (bestGuess != null)
                        tags.add(bestGuess);
                    bestGuess = visualClass.getClassName();
                    bestScore = score;
                } else
                    tags.add(visualClass.getClassName());
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
                new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20, subscriptionKey);

        ClassifyOptions options = new ClassifyOptions.Builder()
                .imagesFile(new URL(link.toString()).openStream())
                .build();

        response = service.classify(options).execute();

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
