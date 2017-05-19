package it.polpetta.libris.opticalCharacterRecognition.ibm.contract;

import it.polpetta.libris.opticalCharacterRecognition.contract.IAbstractOcrFactoryReverseSearchProvider;
import it.polpetta.libris.opticalCharacterRecognition.ibm.characterRecognition.URLIBMOcrSearcher;

/**
 * Created by dpolonio on 10/05/17.
 */
public interface IAbstractIBMOcrFactoryReverseSearchProvider extends IAbstractOcrFactoryReverseSearchProvider {

    URLIBMOcrSearcher.Builder imageSearchBuildQuery();
}
