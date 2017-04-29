package it.polpetta.libris.google.imageSearch.searchers;

import it.polpetta.libris.google.imageSearch.searchers.ISearcher;
import org.json.JSONObject;
import java.net.URL;

/**
 * Created by davide on 29/04/17.
 */
public class prova {

    public static void main (String[] args) {

        try {
            String url1 = "http://upload.wikimedia.org/wikipedia/commons/2/29/Voyager_spacecraft.jpg";
            String url2 = "https://upload.wikimedia.org/wikipedia/commons/6/6b/Miami_FL_Lummus_Park_HD_plantation_slave_qtrs01.jpg";

            ISearcher searcher= new URLSearcher(new URL(url1), null);
            JSONObject res= searcher.search();
            System.out.println(res.toString(2));

            searcher= new URLSearcher(new URL(url2), null);
            res= searcher.search();
            System.out.println(res.toString(2));

        } catch (Exception e) {
            System.err.println("Catch 'em all");
            e.printStackTrace();
        }
    }
}