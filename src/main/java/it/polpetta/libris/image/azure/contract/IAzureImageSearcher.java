package it.polpetta.libris.image.azure.contract;

import it.polpetta.libris.contract.ISearcher;
import it.polpetta.libris.image.google.contract.IGoogleImageSearchResult;

import java.io.IOException;

/**
 * Created by davide on 06/05/17.
 */

// FIXME THIS SHOULD BE A ABSTRACT CLASS THAT EXTENDS ABSTRACTURLSEARCHER AND RETURNS AN IGOOGLEIMAGESEARCHRESULT
public interface IAzureImageSearcher extends ISearcher {

    IAzureImageSearchResult search() throws IOException;

}
