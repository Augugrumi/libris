package it.polpetta.libris.image.google;

import it.polpetta.libris.image.google.contract.IAbstractGoogleImageFactoryReverseSearchProvider;
import it.polpetta.libris.image.google.hmtlImageSearch.URLGoogleImageSearcher;

/**
 * Created by davide on 29/04/17.
 */
public class GoogleAbstractFactory implements IAbstractGoogleImageFactoryReverseSearchProvider {

    public URLGoogleImageSearcher.Builder imageSearchBuildQuery() {
        return new URLGoogleImageSearcher.Builder();
    }
}
