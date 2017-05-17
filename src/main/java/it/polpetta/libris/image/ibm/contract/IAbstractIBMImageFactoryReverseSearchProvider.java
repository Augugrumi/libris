package it.polpetta.libris.image.ibm.contract;

import it.polpetta.libris.image.contract.IAbstractImageFactoryReverseSearchProvider;
import it.polpetta.libris.image.ibm.visualRecognition.URLIBMImageSearcher;

/**
 * Created by dpolonio on 17/05/17.
 */
public interface IAbstractIBMImageFactoryReverseSearchProvider extends IAbstractImageFactoryReverseSearchProvider {

    URLIBMImageSearcher.Builder imageSearchBuildQuery();
}
