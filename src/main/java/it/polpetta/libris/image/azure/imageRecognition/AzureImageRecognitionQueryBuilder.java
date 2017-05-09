package it.polpetta.libris.image.azure.imageRecognition;

import it.polpetta.libris.contract.IQueryBuilder;
import it.polpetta.libris.utils.Coordinates;

import java.io.File;
import java.net.URL;

/**
 * Created by dpolonio on 05/05/17.
 */
public abstract class AzureImageRecognitionQueryBuilder implements IQueryBuilder {

    private File photo = null;
    private URL link = null;
    private Coordinates location = null;

    private AzureImageRecognitionQueryBuilder(){}

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

}
