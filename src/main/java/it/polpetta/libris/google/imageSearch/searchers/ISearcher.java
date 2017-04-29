package it.polpetta.libris.google.imageSearch.searchers;

import org.json.*;

import java.io.IOException;

/**
 * Created by davide on 28/04/17.
 */
public interface ISearcher {

    JSONObject search() throws IOException;
}
