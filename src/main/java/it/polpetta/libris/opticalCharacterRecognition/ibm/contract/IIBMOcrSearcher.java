package it.polpetta.libris.opticalCharacterRecognition.ibm.contract;

import it.polpetta.libris.contract.ISearcher;

import java.io.IOException;

/**
 * Created by davide on 06/05/17.
 */

// FIXME THIS SHOULD BE A ABSTRACT CLASS THAT EXTENDS ABSTRACTURLSEARCHER AND RETURNS AN IGOOGLEIMAGESEARCHRESULT
public interface IIBMOcrSearcher extends ISearcher {

    IIBMOcrResult search() throws IOException;

}
