package it.polpetta.libris.image.imagga.contract;

import it.polpetta.libris.image.contract.IAbstractImageFactoryReverseSearchProvider;
import it.polpetta.libris.image.imagga.imageRecognition.URLImaggaImageSearcher;

/**
 * Created by federico on 17/05/17.
 */
public interface IAbstractImaggaImageFactoryReverseSearchProvider extends IAbstractImageFactoryReverseSearchProvider {
    URLImaggaImageSearcher.Builder imageSearchBuildQuery();
}
