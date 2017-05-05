package it.polpetta.libris;

import it.polpetta.libris.azure.AzureAbstractFactory;
import it.polpetta.libris.google.GoogleAbstractFactory;

/**
 * Created by davide on 28/04/17.
 */
public class ReverseImageSearch {

    public static IAbstractFactoryReverseSearchProvider getGoogleServices() {
        return new GoogleAbstractFactory();
    }

    public static IAbstractFactoryReverseSearchProvider getClarifaiServices() {
        return null;
    }

    public static IAbstractFactoryReverseSearchProvider getAzireServices (String subscriptionKey) {
        return new AzureAbstractFactory(subscriptionKey);
    }
}
