package it.polpetta.libris.utils;

import it.polpetta.libris.utils.SearchResult.ISearchResult;

import java.io.IOException;

/**
 * Created by davide on 28/04/17.
 */
public interface ISearcher {

    ISearchResult search() throws IOException;
}
