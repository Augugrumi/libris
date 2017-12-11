package com.tfederico.libris.image.google.contract;

import com.tfederico.libris.image.contract.IAbstractImageFactoryReverseSearchProvider;
import com.tfederico.libris.image.google.hmtlImageSearch.URLGoogleImageSearcher;

/**
 * Created by dpolonio on 10/05/17.
 */
public interface IAbstractGoogleImageFactoryReverseSearchProvider extends IAbstractImageFactoryReverseSearchProvider {

    URLGoogleImageSearcher.Builder imageSearchBuildQuery();
}