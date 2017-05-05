package it.polpetta.libris.google.imageSearch;

import it.polpetta.libris.IQuery;
import it.polpetta.libris.utils.SearchResult;

/**
 * Created by davide on 28/04/17.
 */
public class GoogleImageSearchQuery implements IQuery {

    private SearchResult res;

    public GoogleImageSearchQuery(SearchResult res){

        this.res = res;
    }

    public SearchResult getContest() {
        return res;
    }
}
