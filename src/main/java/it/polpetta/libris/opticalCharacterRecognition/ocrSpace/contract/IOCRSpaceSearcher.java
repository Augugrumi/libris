package it.polpetta.libris.opticalCharacterRecognition.ocrSpace.contract;

import it.polpetta.libris.contract.ISearcher;

import java.io.IOException;

/**
 * Created by davide on 26/05/17.
 */
public interface IOCRSpaceSearcher extends ISearcher {

    IOCRSpaceSearchResult search() throws IOException;
}
