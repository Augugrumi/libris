package it.polpetta.libris.utils.SearchResult;

import it.polpetta.libris.utils.SearchResult.googleImageSearch.GoogleImageSearchResultBuilder;

/**
 * Created by davide on 06/05/17.
 */
public final class SearchResultBuilderAbstractFactory {

    public static GoogleImageSearchResultBuilder makeGoogleImageSearchBuilder() {
        return new GoogleImageSearchResultBuilder();
    }
}
