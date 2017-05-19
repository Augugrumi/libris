package it.polpetta.libris.image;

import it.polpetta.libris.image.azure.AzureAbstractFactory;
import it.polpetta.libris.contract.IAbstractFactoryReverseSearchProvider;
import it.polpetta.libris.image.azure.contract.IAbstractAzureImageFactoryReverseSearchProvider;
import it.polpetta.libris.image.google.GoogleAbstractFactory;
import it.polpetta.libris.image.google.contract.IAbstractGoogleImageFactoryReverseSearchProvider;
import it.polpetta.libris.image.ibm.IBMAbstractFactory;
import it.polpetta.libris.image.ibm.contract.IAbstractIBMImageFactoryReverseSearchProvider;
import it.polpetta.libris.image.imagga.ImaggaAbstractFactory;
import it.polpetta.libris.image.imagga.contract.IAbstractImaggaImageFactoryReverseSearchProvider;

/**
 * Created by davide on 28/04/17.
 */
public class ReverseImageSearch {

    public static IAbstractGoogleImageFactoryReverseSearchProvider getGoogleServices() {
        return new GoogleAbstractFactory();
    }

    public static IAbstractFactoryReverseSearchProvider getClarifaiServices() {
        return null;
    }

    public static IAbstractAzureImageFactoryReverseSearchProvider getAzureServices(String subscriptionKey) {
        return new AzureAbstractFactory(subscriptionKey);
    }

    public static IAbstractIBMImageFactoryReverseSearchProvider getIBMServices(String subscriptionKey) {
        return new IBMAbstractFactory(subscriptionKey);
    }

    public static IAbstractImaggaImageFactoryReverseSearchProvider getImaggaServices(String subscriptionKey) {
        return new ImaggaAbstractFactory(subscriptionKey);
    }
}
