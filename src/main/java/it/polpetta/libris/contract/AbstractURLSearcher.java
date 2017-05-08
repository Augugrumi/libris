package it.polpetta.libris.contract;

import java.io.IOException;

/**
 * Created by zanna on 08/05/17.
 * its a template method
 *
 * TODO make method abstract if needed and remove useless methods
 */
public abstract class AbstractURLSearcher {
    protected void urlConnection(){}
    protected void retrieveData(){}
    protected void setConnectionParameters(){}
    protected void parseResult(){}
    public ISearchResult search() throws IOException {return null;}
}
