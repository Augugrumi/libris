package it.polpetta.libris.opticalCharacterRecognition.azure;

import it.polpetta.libris.opticalCharacterRecognition.azure.characterRecognition.URLAzureOcrSearcher;
import it.polpetta.libris.opticalCharacterRecognition.azure.contract.IAbstractAzureOcrFactoryReverseSearchProvider;

/**
 * Created by zanna on 11/05/17.
 */
public class AzureAbstractFactory implements IAbstractAzureOcrFactoryReverseSearchProvider {

    private String subscriptionKey = null;

    public AzureAbstractFactory(String subscriptionKey) {

        this.subscriptionKey = subscriptionKey;
    }

    public URLAzureOcrSearcher.Builder imageSearchBuildQuery() {
        URLAzureOcrSearcher.setSubscriptionKey(subscriptionKey);
        return new URLAzureOcrSearcher.Builder();
    }
}
