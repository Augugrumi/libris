package it.polpetta.libris.google.imageSearch;

import it.polpetta.libris.IQuery;
import it.polpetta.libris.utils.SearchResult.ISearchResult;
import it.polpetta.libris.utils.SearchResult.googleImageSearch.IGoogleImageSearchResult;

/**
 * Created by davide on 28/04/17.
 */
public class GoogleImageSearchQuery implements IQuery {

    private IGoogleImageSearchResult res;

    public GoogleImageSearchQuery(IGoogleImageSearchResult res){

        this.res = res;
    }

    public IGoogleImageSearchResult getContest() {
        return res;
    }
}
