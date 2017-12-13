package com.tfederico.libris.image.ibm.contract;

import com.tfederico.libris.image.contract.IAbstractImageFactoryReverseSearchProvider;
import com.tfederico.libris.image.ibm.visualRecognition.URLIBMImageSearcher;

/**
 * Created by dpolonio on 17/05/17.
 */
public interface IAbstractIBMImageFactoryReverseSearchProvider extends IAbstractImageFactoryReverseSearchProvider {

    URLIBMImageSearcher.Builder imageSearchBuildQuery();
}
