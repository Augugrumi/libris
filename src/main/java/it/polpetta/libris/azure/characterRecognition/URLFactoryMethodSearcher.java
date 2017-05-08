package it.polpetta.libris.azure.characterRecognition;

import it.polpetta.libris.google.imageSearch.Coordinates;
import it.polpetta.libris.utils.AbstractFactoryMethodSearcher;
import it.polpetta.libris.utils.ISearcher;

import java.net.URL;

/**
 * Created by dpolonio on 05/05/17.
 */
public class URLFactoryMethodSearcher extends AbstractFactoryMethodSearcher {

    private String subscriptionKey = null;
    private URL imagePath = null;

    public URLFactoryMethodSearcher (Coordinates location, URL imagePath, String subscriptionKey) {
        super(location);

        this.subscriptionKey = subscriptionKey;
    }

    @Override
    public ISearcher makeSearcher() {
        return new URLSearcher(imagePath, subscriptionKey);
    }
}
