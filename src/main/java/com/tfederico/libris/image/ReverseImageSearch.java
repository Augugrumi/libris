package com.tfederico.libris.image;

import com.tfederico.libris.contract.IAbstractFactoryReverseSearchProvider;
import com.tfederico.libris.image.google.GoogleAbstractFactory;
import com.tfederico.libris.image.google.contract.IAbstractGoogleImageFactoryReverseSearchProvider;
import com.tfederico.libris.image.imagga.ImaggaAbstractFactory;
import com.tfederico.libris.image.imagga.contract.IAbstractImaggaImageFactoryReverseSearchProvider;
import com.tfederico.libris.image.azure.AzureAbstractFactory;
import com.tfederico.libris.image.azure.contract.IAbstractAzureImageFactoryReverseSearchProvider;
import com.tfederico.libris.image.ibm.IBMAbstractFactory;
import com.tfederico.libris.image.ibm.contract.IAbstractIBMImageFactoryReverseSearchProvider;

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
