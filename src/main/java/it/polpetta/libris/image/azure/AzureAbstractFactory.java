package it.polpetta.libris.image.azure;

import it.polpetta.libris.contract.IAbstractFactoryReverseSearchProvider;
import it.polpetta.libris.contract.IQueryBuilder;
import it.polpetta.libris.image.azure.imageRecognition.AzureImageRecognitionQueryBuilder;

/**
 * Created by dpolonio on 05/05/17.
 */
public class AzureAbstractFactory implements IAbstractFactoryReverseSearchProvider {

    private String subscriptionKey = null;

    public AzureAbstractFactory(String subscriptionKey) {

        this.subscriptionKey = subscriptionKey;
    }

    public IQueryBuilder imageSearchBuildQuery() {
        return null; //new AzureImageRecognitionQueryBuilder(subscriptionKey);
    }

}
