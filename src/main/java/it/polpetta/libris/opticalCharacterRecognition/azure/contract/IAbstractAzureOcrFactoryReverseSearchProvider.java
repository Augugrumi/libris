package it.polpetta.libris.opticalCharacterRecognition.azure.contract;

import it.polpetta.libris.contract.IQueryBuilder;
import it.polpetta.libris.opticalCharacterRecognition.azure.characterRecognition.URLAzureOcrSearcher;
import it.polpetta.libris.opticalCharacterRecognition.contract.IAbstractOcrFactoryReverseSearchProvider;

/**
 * Created by dpolonio on 10/05/17.
 */
public interface IAbstractAzureOcrFactoryReverseSearchProvider extends IAbstractOcrFactoryReverseSearchProvider {

    URLAzureOcrSearcher.Builder imageSearchBuildQuery();
}
