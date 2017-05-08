package it.polpetta.libris.image.azure.imageRecognition.searchers;

import it.polpetta.libris.utils.Coordinates;
import it.polpetta.libris.contract.AbstractFactoryMethodSearcher;
import it.polpetta.libris.contract.ISearcher;

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
