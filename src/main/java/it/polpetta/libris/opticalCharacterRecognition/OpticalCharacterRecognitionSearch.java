package it.polpetta.libris.opticalCharacterRecognition;

import it.polpetta.libris.opticalCharacterRecognition.azure.AzureAbstractFactory;
import it.polpetta.libris.opticalCharacterRecognition.azure.contract.IAbstractAzureOcrFactoryReverseSearchProvider;

/**
 * Created by zanna on 11/05/17.
 */
public class OpticalCharacterRecognitionSearch {

    private OpticalCharacterRecognitionSearch() {

    }

    public static IAbstractAzureOcrFactoryReverseSearchProvider getAzureServices(String subscriptionKey) {
        return new AzureAbstractFactory(subscriptionKey);
    }
}
