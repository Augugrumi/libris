package it.polpetta.libris.azure;

import it.polpetta.libris.IAbstractFactoryReverseSearchProvider;
import it.polpetta.libris.IQueryBuilder;
import it.polpetta.libris.azure.imageRecognition.AzureImageRecognitionQueryBuilder;

/**
 * Created by dpolonio on 05/05/17.
 */
public class AzureAbstractFactory implements IAbstractFactoryReverseSearchProvider {

    private String subscriptionKey = null;

    public AzureAbstractFactory(String subscriptionKey) {

        this.subscriptionKey = subscriptionKey;
    }

    public IQueryBuilder imageSearchBuildQuery() {
        return new AzureImageRecognitionQueryBuilder(subscriptionKey);
    }

}
