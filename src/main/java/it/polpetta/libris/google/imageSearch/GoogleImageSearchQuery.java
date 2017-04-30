package it.polpetta.libris.google.imageSearch;

import it.polpetta.libris.IQuery;
import org.json.JSONObject;

/**
 * Created by davide on 28/04/17.
 */
public class GoogleImageSearchQuery implements IQuery {

    private JSONObject res;

    public GoogleImageSearchQuery(JSONObject res){

        this.res = res;
    }

    public JSONObject getContest() {
        return res;
    }
}
