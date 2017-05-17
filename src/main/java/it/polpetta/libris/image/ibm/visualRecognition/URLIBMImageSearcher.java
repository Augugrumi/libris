package it.polpetta.libris.image.ibm.visualRecognition;

import it.polpetta.libris.contract.AbstractURLSearcher;
import it.polpetta.libris.contract.ISearchResult;
import it.polpetta.libris.image.contract.IImageSearchResult;
import it.polpetta.libris.image.ibm.contract.IIBMImageSearcher;
import it.polpetta.libris.image.ibm.contract.IIBMSearchResult;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by dpolonio on 17/05/17.
 */
public class URLIBMImageSearcher extends AbstractURLSearcher implements IIBMImageSearcher {

    private static String subscriptionKey = null;

    public URLIBMImageSearcher (URL link) {
        super(link);

    }

    public static void setSubscriptionKey(String key) {
        subscriptionKey = key;
    }

    @Override
    protected URLConnection setConnectionParameters() {
        return null;
    }

    @Override
    protected ISearchResult parseResult(String response) {
        return null;
    }

    @Override
    public IIBMSearchResult search() throws IOException {
        return (IIBMSearchResult) super.search();
    }
}
