package it.polpetta.libris.google.imageSearch.searchers;

import it.polpetta.libris.google.imageSearch.SearchResult;

import java.io.IOException;

/**
 * Created by davide on 28/04/17.
 */
public interface ISearcher {

    SearchResult search() throws IOException;
}
