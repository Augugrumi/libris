package it.polpetta.libris.google.imageSearch;

import it.polpetta.libris.IQuery;
import it.polpetta.libris.IQueryBuilder;
import it.polpetta.libris.utils.AbstractFactoryMethodSearcher;
import it.polpetta.libris.utils.ISearcher;
import it.polpetta.libris.google.imageSearch.searchers.URLFactoryMethodSearcher;
import it.polpetta.libris.utils.SearchResult;

import java.io.File;
import java.io.IOException;
import java.net.URL;


/**
 * Created by davide on 28/04/17.
 */
public class GoogleImageSearchQueryBuilder implements IQueryBuilder {

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

        // do the query

        ISearcher searcher = null;
        AbstractFactoryMethodSearcher factory;
        SearchResult res = null;

        // FIXME
        if (link != null) {
            factory = new URLFactoryMethodSearcher(location, link);
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
