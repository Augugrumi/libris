package it.polpetta.libris.image;

import it.polpetta.libris.image.azure.contract.IAzureImageSearchResult;
import it.polpetta.libris.image.contract.IImageSearchResult;
import it.polpetta.libris.image.google.contract.IGoogleImageSearchResult;
import junit.framework.*;
import org.junit.Assert;
import org.junit.Ignore;

import java.net.URL;


/**
 * Created by zanna on 11/05/17.
 */
public class ReverseImageSearchTest extends TestCase {

    public void testAzureImageSearchReturnNotNull() {
        try {
            URL url = new URL("http://1.bp.blogspot.com/-EZ-EdfiRhUc/VU75RcSB8OI/AAAAAAAAC4E/7ouyZ9H-zco/s1600/patata.jpg");
            String key = System.getenv("AZURE_KEY");
            IAzureImageSearchResult res = ReverseImageSearch
                    .getAzureServices(key)
                    .imageSearchBuildQuery()
                    .setImage(url)
                    .build()
                    .search();
            org.junit.Assert.assertNotNull(res);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @Ignore
    public void testGoogleImageSearchReturnNotNull() {
        try {
            URL url = new URL("http://1.bp.blogspot.com/-EZ-EdfiRhUc/VU75RcSB8OI/AAAAAAAAC4E/7ouyZ9H-zco/s1600/patata.jpg");
            IGoogleImageSearchResult res = ReverseImageSearch
                    .getGoogleServices()
                    .imageSearchBuildQuery()
                    .setImage(url)
                    .build()
                    .search();
            org.junit.Assert.assertNotNull(res);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    public void testImmagaImageSearchReturnNotNull() {
        try {
            URL url = new URL("http://1.bp.blogspot.com/-EZ-EdfiRhUc/VU75RcSB8OI/AAAAAAAAC4E/7ouyZ9H-zco/s1600/patata.jpg");
            String key = System.getenv("IMAGGA_KEY") + ":" +
                    System.getenv("IMAGGA_SECRET");

            IImageSearchResult res = ReverseImageSearch
                    .getImaggaServices(key)
                    .imageSearchBuildQuery()
                    .setImage(url)
                    .build()
                    .search();
            System.out.println(res.toJSONString());
            org.junit.Assert.assertNotNull(res);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

}