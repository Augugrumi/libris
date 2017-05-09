package it.polpetta.libris.contract;

import it.polpetta.libris.utils.Coordinates;
import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by zanna on 08/05/17.
 * its a template method
 *
 * TODO make method abstract if needed and remove useless methods
 */
public abstract class AbstractURLSearcher {

    protected URL link;

    public AbstractURLSearcher(URL link) {
        this.link = link;
    }

    public static void printMalformedError (MalformedURLException e) {
        System.err.println("An error occurred parsing the URL!");
        e.printStackTrace();
    }

    public static URL stringToURL(String url) {
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            printMalformedError(e);
        }
        return null;
    }


    protected abstract URLConnection setConnectionParameters();

    protected String retrieveData(URLConnection url) {
        StringBuilder response = new StringBuilder("");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(url.getInputStream()));
            boolean iterate = true;
            while (iterate) {
                String nextLine = in.readLine();
                if (nextLine == null)
                    iterate = false;
                else
                    response.append(nextLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.toString();
    }

    protected abstract ISearchResult parseResult(String response);

    public ISearchResult search() throws IOException {
        URLConnection request = setConnectionParameters();
        String response = retrieveData(request);
        return parseResult(response);
    }
}
