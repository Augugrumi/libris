package it.polpetta.libris.google.imageSearch;

import it.polpetta.libris.IQuery;
import it.polpetta.libris.IQueryBuilder;
import it.polpetta.libris.google.imageSearch.searchers.AbstractFactoryMethodSearcher;
import it.polpetta.libris.google.imageSearch.searchers.ISearcher;
import it.polpetta.libris.google.imageSearch.searchers.URLFactoryMethodSearcher;

import java.io.File;
import java.net.URL;
import org.json.*;


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
        JSONObject res;

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

        // res = searcher.search();

        // Transform res into a String[]
        return new GoogleImageSearchQuery(null);
    }
}
