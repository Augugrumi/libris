package com.tfederico.libris.image.azure.contract;

import com.tfederico.libris.image.azure.imageRecognition.URLAzureImageSearcher;
import com.tfederico.libris.image.contract.IAbstractImageFactoryReverseSearchProvider;

/**
 * Created by dpolonio on 10/05/17.
 */
public interface IAbstractAzureImageFactoryReverseSearchProvider extends IAbstractImageFactoryReverseSearchProvider {

    URLAzureImageSearcher.Builder imageSearchBuildQuery();
}
