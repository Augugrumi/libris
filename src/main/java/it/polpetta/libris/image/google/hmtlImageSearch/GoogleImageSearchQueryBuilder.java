package it.polpetta.libris.image.google.hmtlImageSearch;

import it.polpetta.libris.contract.IQueryBuilder;
import it.polpetta.libris.image.contract.IImageQueryBuilder;
import it.polpetta.libris.image.google.contract.IGoogleImageSearchResult;
import it.polpetta.libris.utils.Coordinates;

import java.io.File;
import java.net.URL;


/**
 * Created by davide on 28/04/17.
 */
public class GoogleImageSearchQueryBuilder implements IImageQueryBuilder {

    private File photo = null;
    private URL link = null;
    private Coordinates location = null;


    public IQueryBuilder setLocation(float x, float y) {

        location = new Coordinates(x, y);

        return this;
    }

    @Override
    public IQueryBuilder setImage(File file) {
        photo = file;
        return this;
    }

    @Override
    public IQueryBuilder setImage(URL linkToImage) {
        link = linkToImage;
        return this;
    }

    public IGoogleImageSearchResult runQuery() {

        /*IGoogleImageSearcher searcher = null;
        AbstractFactoryMethodSearcher factory;
        IGoogleImageSearchResult res = null;

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

        return res;*/
        return null;
    }
}
