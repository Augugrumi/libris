package it.polpetta.libris.opticalCharacterRecognition.ocrSpace.contract;

import it.polpetta.libris.opticalCharacterRecognition.contract.IAbstractOcrFactoryReverseSearchProvider;
import it.polpetta.libris.opticalCharacterRecognition.ocrSpace.freeOcr.FreeOCRSpaceSearcher;

/**
 * Created by davide on 26/05/17.
 */
public interface IAbstractOCRSpaceFactoryReverseSearchProvider extends IAbstractOcrFactoryReverseSearchProvider {

    FreeOCRSpaceSearcher.Builder imageSearchBuildQuery();

}
