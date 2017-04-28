package it.polpetta.libris.google.imageSearch.searchers;

import it.polpetta.libris.google.imageSearch.Coordinates;
import org.json.*;

import java.net.URL;

/**
 * Created by davide on 28/04/17.
 */
class URLSearcher implements ISearcher {

    private URL link = null;
    private Coordinates location = null;

    URLSearcher (URL link, Coordinates location) {

        this.link = link;
        this.location = location;
    }

    public JSONObject search() {

        // TODO qui implemento la ricerca con richiesta e tutto

        return null;
    }
}
