package it.polpetta.libris.google.imageSearch;

import it.polpetta.libris.IQuery;
import it.polpetta.libris.utils.SearchResult.ISearchResult;
import it.polpetta.libris.utils.SearchResult.googleImageSearch.IGoogleImageSearchResult;

/**
 * Created by davide on 28/04/17.
 */
public class GoogleImageSearchQuery implements IQuery {

    private ISearchResult res;

    public GoogleImageSearchQuery(ISearchResult res){

        this.res = res;
    }

    public ISearchResult getContest() {
        return res;
    }
}
