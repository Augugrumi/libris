package it.polpetta.libris.image;

import it.polpetta.libris.image.azure.AzureAbstractFactory;
import it.polpetta.libris.contract.IAbstractFactoryReverseSearchProvider;
import it.polpetta.libris.image.azure.contract.IAbstractAzureImageFactoryReverseSearchProvider;
import it.polpetta.libris.image.google.GoogleAbstractFactory;
import it.polpetta.libris.image.google.contract.IAbstractGoogleImageFactoryReverseSearchProvider;

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
}
