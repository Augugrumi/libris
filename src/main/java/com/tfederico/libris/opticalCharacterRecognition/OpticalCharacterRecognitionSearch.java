package com.tfederico.libris.opticalCharacterRecognition;

import com.tfederico.libris.opticalCharacterRecognition.azure.contract.IAbstractAzureOcrFactoryReverseSearchProvider;
import com.tfederico.libris.opticalCharacterRecognition.azure.AzureAbstractFactory;
//import it.polpetta.libris.opticalCharacterRecognition.ibm.IBMAbstractFactory;
//import it.polpetta.libris.opticalCharacterRecognition.ibm.contract.IAbstractIBMOcrFactoryReverseSearchProvider;

/**
 * Created by zanna on 11/05/17.
 */
public class OpticalCharacterRecognitionSearch {

    private OpticalCharacterRecognitionSearch() {}

    public static IAbstractAzureOcrFactoryReverseSearchProvider getAzureServices(String subscriptionKey) {
        return new AzureAbstractFactory(subscriptionKey);
    }

    /*public static IAbstractIBMOcrFactoryReverseSearchProvider getIBMServices(String subscriptionKey) {
        return new IBMAbstractFactory(subscriptionKey);
    }*/
}
