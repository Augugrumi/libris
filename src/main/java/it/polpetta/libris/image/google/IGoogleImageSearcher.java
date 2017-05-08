package it.polpetta.libris.image.google;

import it.polpetta.libris.contract.ISearcher;
import it.polpetta.libris.image.google.contract.IGoogleImageSearchResult;

import java.io.IOException;

/**
 * Created by davide on 06/05/17.
 */
public interface IGoogleImageSearcher extends ISearcher {

    IGoogleImageSearchResult search() throws IOException;

}
