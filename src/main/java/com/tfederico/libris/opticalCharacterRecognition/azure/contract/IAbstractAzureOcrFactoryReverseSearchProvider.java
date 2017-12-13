package com.tfederico.libris.opticalCharacterRecognition.azure.contract;

import com.tfederico.libris.opticalCharacterRecognition.azure.characterRecognition.URLAzureOcrSearcher;
import com.tfederico.libris.opticalCharacterRecognition.contract.IAbstractOcrFactoryReverseSearchProvider;

/**
 * Created by dpolonio on 10/05/17.
 */
public interface IAbstractAzureOcrFactoryReverseSearchProvider extends IAbstractOcrFactoryReverseSearchProvider {

    URLAzureOcrSearcher.Builder imageSearchBuildQuery();
}
