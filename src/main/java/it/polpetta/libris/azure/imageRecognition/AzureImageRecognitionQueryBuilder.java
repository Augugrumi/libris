package it.polpetta.libris.azure.imageRecognition;

import it.polpetta.libris.IQuery;
import it.polpetta.libris.IQueryBuilder;
import it.polpetta.libris.azure.imageRecognition.searchers.URLFactoryMethodSearcher;
import it.polpetta.libris.google.imageSearch.Coordinates;
import it.polpetta.libris.utils.ISearcher;
import it.polpetta.libris.utils.SearchResult.ISearchResult;

import java.io.File;
import java.net.URL;

/**
 * Created by dpolonio on 05/05/17.
 */
public class AzureImageRecognitionQueryBuilder implements IQueryBuilder {

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

    public IQuery runQuery () {

        ISearcher searcher = null;
        URLFactoryMethodSearcher factoryMethodSearcher;
        ISearchResult res = null;

        return null;
    }
}
