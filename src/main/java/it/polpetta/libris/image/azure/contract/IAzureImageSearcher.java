package com.tfederico.libris.image.azure.contract;

import com.tfederico.libris.contract.ISearcher;

import java.io.IOException;

/**
 * Created by davide on 06/05/17.
 */

// FIXME THIS SHOULD BE A ABSTRACT CLASS THAT EXTENDS ABSTRACTURLSEARCHER AND RETURNS AN IGOOGLEIMAGESEARCHRESULT
public interface IAzureImageSearcher extends ISearcher {

    IAzureImageSearchResult search() throws IOException;

}
