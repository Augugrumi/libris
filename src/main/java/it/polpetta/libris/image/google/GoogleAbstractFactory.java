package it.polpetta.libris.image.google;

import it.polpetta.libris.contract.IAbstractFactoryReverseSearchProvider;
import it.polpetta.libris.contract.IQueryBuilder;
import it.polpetta.libris.image.google.hmtlImageSearch.GoogleImageSearchQueryBuilder;

/**
 * Created by davide on 29/04/17.
 */
public class GoogleAbstractFactory implements IAbstractFactoryReverseSearchProvider {

    public IQueryBuilder imageSearchBuildQuery() {
        return new GoogleImageSearchQueryBuilder();
    }
}
