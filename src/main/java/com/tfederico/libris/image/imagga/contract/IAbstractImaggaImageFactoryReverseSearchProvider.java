package com.tfederico.libris.image.imagga.contract;

import com.tfederico.libris.image.contract.IAbstractImageFactoryReverseSearchProvider;
import com.tfederico.libris.image.imagga.imageRecognition.URLImaggaImageSearcher;

/**
 * Created by federico on 17/05/17.
 */
public interface IAbstractImaggaImageFactoryReverseSearchProvider extends IAbstractImageFactoryReverseSearchProvider {
    URLImaggaImageSearcher.Builder imageSearchBuildQuery();
}
