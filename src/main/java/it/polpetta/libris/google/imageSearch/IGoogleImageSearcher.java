package it.polpetta.libris.google.imageSearch;

import it.polpetta.libris.utils.ISearcher;
import it.polpetta.libris.utils.SearchResult.googleImageSearch.IGoogleImageSearchResult;

import java.io.IOException;

/**
 * Created by davide on 06/05/17.
 */
public interface IGoogleImageSearcher extends ISearcher {

    IGoogleImageSearchResult search() throws IOException;

}
