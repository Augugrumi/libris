package it.polpetta.libris.google.imageSearch;

import it.polpetta.libris.IQuery;

/**
 * Created by davide on 28/04/17.
 */
public class GoogleImageSearchQuery implements IQuery {

    private String[] res;

    public GoogleImageSearchQuery(String[] res){

        this.res = res;
    }

    public String[] getContest() {
        return res;
    }
}
