package it.polpetta.libris;

import com.sun.istack.internal.NotNull;
import it.polpetta.libris.google.GoogleAbstractFactory;

/**
 * Created by davide on 28/04/17.
 */
public class ReverseImageSearch {

    @NotNull
    public static IAbstractFactoryReverseSearchProvider getGoogleServices() {
        return new GoogleAbstractFactory();
    }

    // TODO set it as @NotNull
    public static IAbstractFactoryReverseSearchProvider getClarifaiServices() {
        return null;
    }
}
