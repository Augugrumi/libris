package it.polpetta.libris.contract;

import it.polpetta.libris.contract.ISearchResult;

import java.io.IOException;

/**
 * Created by davide on 28/04/17.
 *
 * TODO to remove?
 */
public interface ISearcher {

    ISearchResult search() throws IOException;
}
