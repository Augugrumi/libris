package it.polpetta.libris.image.imagga;

import it.polpetta.libris.image.imagga.contract.IAbstractImaggaImageFactoryReverseSearchProvider;
import it.polpetta.libris.image.imagga.imageRecognition.URLImaggaImageSearcher;

/**
 * Created by federico on 17/05/17.
 */
public class ImaggaAbstractFactory implements IAbstractImaggaImageFactoryReverseSearchProvider {
    private String subscriptionKey = null;

    public ImaggaAbstractFactory(String subscriptionKey) {

        this.subscriptionKey = subscriptionKey;
    }

    public URLImaggaImageSearcher.Builder imageSearchBuildQuery() {
        URLImaggaImageSearcher.setSubscriptionKey(subscriptionKey);
        return new URLImaggaImageSearcher.Builder();
    }
}
