package it.polpetta.libris.image.google;

import it.polpetta.libris.contract.IQuery;
import it.polpetta.libris.image.google.contract.IGoogleImageSearchResult;

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
