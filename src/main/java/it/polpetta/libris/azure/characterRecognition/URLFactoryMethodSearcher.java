package it.polpetta.libris.azure.characterRecognition;

import it.polpetta.libris.google.imageSearch.Coordinates;
import it.polpetta.libris.utils.AbstractFactoryMethodSearcher;
import it.polpetta.libris.utils.ISearcher;

/**
 * Created by dpolonio on 05/05/17.
 */
public class URLFactoryMethodSearcher extends AbstractFactoryMethodSearcher {

    private String subscriptionKey = null;

    public URLFactoryMethodSearcher (Coordinates location, String subscriptionKey) {
        super(location);

        this.subscriptionKey = subscriptionKey;
    }

    @Override
    public ISearcher makeSearcher() {
        return new URLSearcher(subscriptionKey);
    }
}
