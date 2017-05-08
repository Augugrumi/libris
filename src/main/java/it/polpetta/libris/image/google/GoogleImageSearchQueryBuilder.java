package it.polpetta.libris.image.google;

import it.polpetta.libris.contract.IQuery;
import it.polpetta.libris.contract.IQueryBuilder;
import it.polpetta.libris.contract.AbstractFactoryMethodSearcher;
import it.polpetta.libris.contract.ISearcher;
import it.polpetta.libris.image.contract.IImageQueryBuilder;
import it.polpetta.libris.image.google.searchers.URLFactoryMethodSearcher;
import it.polpetta.libris.contract.ISearchResult;
import it.polpetta.libris.utils.Coordinates;

import java.io.File;
import java.io.IOException;
import java.net.URL;


/**
 * Created by davide on 28/04/17.
 */
public class GoogleImageSearchQueryBuilder implements IImageQueryBuilder {

    private File photo = null;
    private URL link = null;
    private Coordinates location = null;

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

    public IQuery runQuery() {

        ISearcher searcher = null;
        AbstractFactoryMethodSearcher factory;
        ISearchResult res = null;

        // FIXME
        if (link != null) {
            factory = new URLFactoryMethodSearcher(location, link);
            // In order to use IGoogleImageSearcher we should downcast here!
            searcher = factory.makeSearcher();
        } else if (photo != null) {
            // TODO
        }
        else {
            return null; // No link or photo provided
        }

        try {
            res = searcher.search();
        } catch (IOException e) {

            System.err.println("Error while searching the resources");
            e.printStackTrace();
        }

        return new GoogleImageSearchQuery(res);
    }
}
