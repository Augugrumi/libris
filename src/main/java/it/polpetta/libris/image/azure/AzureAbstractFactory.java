package it.polpetta.libris.image.azure;

import it.polpetta.libris.contract.IAbstractFactoryReverseSearchProvider;
import it.polpetta.libris.contract.IQueryBuilder;

/**
 * Created by dpolonio on 05/05/17.
 */
public class AzureAbstractFactory implements IAbstractFactoryReverseSearchProvider {

    private String subscriptionKey = null;

    public AzureAbstractFactory(String subscriptionKey) {

        this.subscriptionKey = subscriptionKey;
    }

    // TODO implement this beautiful method
    public IQueryBuilder imageSearchBuildQuery() {
        return null;
    }

}
