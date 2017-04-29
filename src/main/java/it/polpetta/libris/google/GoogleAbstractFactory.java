package it.polpetta.libris.google;

import it.polpetta.libris.IAbstractFactoryReverseSearchProvider;
import it.polpetta.libris.IQueryBuilder;
import it.polpetta.libris.google.imageSearch.GoogleImageSearchQueryBuilder;

/**
 * Created by davide on 29/04/17.
 */
public class GoogleAbstractFactory implements IAbstractFactoryReverseSearchProvider {

    public IQueryBuilder imageSearchBuildQuery() {
        return new GoogleImageSearchQueryBuilder();
    }
}
