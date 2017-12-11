package it.polpetta.libris.image.ibm;


import it.polpetta.libris.image.ibm.contract.IAbstractIBMImageFactoryReverseSearchProvider;
import it.polpetta.libris.image.ibm.visualRecognition.URLIBMImageSearcher;

/**
 * Created by dpolonio on 17/05/17.
 */
public class IBMAbstractFactory implements IAbstractIBMImageFactoryReverseSearchProvider {

    private String subscriptionKey = null;

    public IBMAbstractFactory(String subscriptionKey) {

        this.subscriptionKey = subscriptionKey;
    }

    @Override
    public URLIBMImageSearcher.Builder imageSearchBuildQuery() {
        URLIBMImageSearcher.setSubscriptionKey(subscriptionKey);
        return new URLIBMImageSearcher.Builder();


    }
}
