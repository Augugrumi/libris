package it.polpetta.libris.opticalCharacterRecognition.azure.contract;

import it.polpetta.libris.contract.ISearcher;
import it.polpetta.libris.image.azure.contract.IAzureImageSearchResult;

import java.io.IOException;

/**
 * Created by davide on 06/05/17.
 */

// FIXME THIS SHOULD BE A ABSTRACT CLASS THAT EXTENDS ABSTRACTURLSEARCHER AND RETURNS AN IGOOGLEIMAGESEARCHRESULT
public interface IAzureOcrSearcher extends ISearcher {

    IAzureOcrResult search() throws IOException;

}
