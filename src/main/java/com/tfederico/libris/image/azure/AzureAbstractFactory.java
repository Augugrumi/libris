package com.tfederico.libris.image.azure;

import com.tfederico.libris.image.azure.contract.IAbstractAzureImageFactoryReverseSearchProvider;
import com.tfederico.libris.image.azure.imageRecognition.URLAzureImageSearcher;

/**
 * Created by dpolonio on 05/05/17.
 */
public class AzureAbstractFactory implements IAbstractAzureImageFactoryReverseSearchProvider {

    private String subscriptionKey = null;

    public AzureAbstractFactory(String subscriptionKey) {

        this.subscriptionKey = subscriptionKey;
    }

    public URLAzureImageSearcher.Builder imageSearchBuildQuery() {
        URLAzureImageSearcher.setSubscriptionKey(subscriptionKey);
        return new URLAzureImageSearcher.Builder();
    }

}
