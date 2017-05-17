package it.polpetta.libris.image.ibm;

import it.polpetta.libris.contract.IQueryBuilder;
import it.polpetta.libris.image.ibm.contract.IAbstractIBMImageFactoryReverseSearchProvider;

/**
 * Created by dpolonio on 17/05/17.
 */
public class IBMAbstractFactory implements IAbstractIBMImageFactoryReverseSearchProvider {

    private String subscriptionKey = null;

    public IBMAbstractFactory(String subscriptionKey) {

        this.subscriptionKey = subscriptionKey;
    }

    // FIXME change this return type!
    @Override
    public IQueryBuilder imageSearchBuildQuery() {
        return null;
    }
}
