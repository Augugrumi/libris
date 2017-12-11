package it.polpetta.libris.image.google.contract;

import it.polpetta.libris.image.contract.IAbstractImageFactoryReverseSearchProvider;
import it.polpetta.libris.image.google.hmtlImageSearch.URLGoogleImageSearcher;

/**
 * Created by dpolonio on 10/05/17.
 */
public interface IAbstractGoogleImageFactoryReverseSearchProvider extends IAbstractImageFactoryReverseSearchProvider {

    URLGoogleImageSearcher.Builder imageSearchBuildQuery();
}