package it.polpetta.libris.image.azure;

import it.polpetta.libris.contract.IQueryBuilder;
import it.polpetta.libris.image.azure.contract.IAbstractAzureImageFactoryReverseSearchProvider;
import it.polpetta.libris.image.azure.imageRecognition.URLAzureImageSearcher;

/**
 * Created by dpolonio on 05/05/17.
 */
public class AzureAbstractFactory implements IAbstractAzureImageFactoryReverseSearchProvider {

    private String subscriptionKey = null;

    public AzureAbstractFactory(String subscriptionKey) {

        this.subscriptionKey = subscriptionKey;
    }

    // TODO implement this beautiful method
    public URLAzureImageSearcher.Builder imageSearchBuildQuery() {
        return new URLAzureImageSearcher.Builder();
    }

}
