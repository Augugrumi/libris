package it.polpetta.libris.opticalCharacterRecognition;

import it.polpetta.libris.opticalCharacterRecognition.azure.AzureAbstractFactory;
import it.polpetta.libris.opticalCharacterRecognition.azure.contract.IAbstractAzureOcrFactoryReverseSearchProvider;
import it.polpetta.libris.opticalCharacterRecognition.ibm.IBMAbstractFactory;
import it.polpetta.libris.opticalCharacterRecognition.ibm.contract.IAbstractIBMOcrFactoryReverseSearchProvider;
import it.polpetta.libris.opticalCharacterRecognition.ocrSpace.OCRSpaceAbstractFactory;
import it.polpetta.libris.opticalCharacterRecognition.ocrSpace.contract.IAbstractOCRSpaceFactoryReverseSearchProvider;

/**
 * Created by zanna on 11/05/17.
 */
public class OpticalCharacterRecognitionSearch {

    private OpticalCharacterRecognitionSearch() {}

    public static IAbstractAzureOcrFactoryReverseSearchProvider getAzureServices(String subscriptionKey) {
        return new AzureAbstractFactory(subscriptionKey);
    }

    public static IAbstractIBMOcrFactoryReverseSearchProvider getIBMServices(String subscriptionKey) {
        return new IBMAbstractFactory(subscriptionKey);
    }

    public static IAbstractOCRSpaceFactoryReverseSearchProvider getOCRSpaceServices(String subscriptionKey) {
        return new OCRSpaceAbstractFactory(subscriptionKey);
    }
}
