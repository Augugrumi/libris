package it.polpetta.libris.image.azure.imageRecognition;

import it.polpetta.libris.contract.IQueryBuilder;
import it.polpetta.libris.image.azure.imageRecognition.searchers.URLFactoryMethodSearcher;
import it.polpetta.libris.utils.Coordinates;
import it.polpetta.libris.contract.ISearcher;
import it.polpetta.libris.contract.ISearchResult;

import java.io.File;
import java.net.URL;

/**
 * Created by dpolonio on 05/05/17.
 */
public abstract class AzureImageRecognitionQueryBuilder implements IQueryBuilder {

    private File photo = null;
    private URL link = null;
    private Coordinates location = null;
    private String subscriptionKey = null;

    public AzureImageRecognitionQueryBuilder (String subscriptionKey) {
        this.subscriptionKey = subscriptionKey;
    }

    public IQueryBuilder setPhoto(File file) {

        photo = file;

        return this;
    }

    public IQueryBuilder setPhoto(URL linkToImage) {

        link = linkToImage;

        return this;
    }

    public IQueryBuilder setLocation(float x, float y) {

        location = new Coordinates(x, y);

        return this;
    }

    /*public IQuery runQuery () {

        ISearcher searcher = null;
        URLFactoryMethodSearcher factoryMethodSearcher;
        ISearchResult res = null;

        return null;
    }*/
}
