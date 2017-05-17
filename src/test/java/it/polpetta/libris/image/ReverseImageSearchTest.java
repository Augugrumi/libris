package it.polpetta.libris.image;

import it.polpetta.libris.image.azure.contract.IAzureImageSearchResult;
import it.polpetta.libris.image.google.contract.IGoogleImageSearchResult;
import it.polpetta.libris.image.ibm.contract.IIBMImageSearchResult;
import junit.framework.Assert;
import junit.framework.TestCase;

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
            Assert.assertNotNull(res);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    public void testGoogleImageSearchReturnNotNull() {
        try {
            URL url = new URL("http://1.bp.blogspot.com/-EZ-EdfiRhUc/VU75RcSB8OI/AAAAAAAAC4E/7ouyZ9H-zco/s1600/patata.jpg");
            IGoogleImageSearchResult res = ReverseImageSearch
                    .getGoogleServices()
                    .imageSearchBuildQuery()
                    .setImage(url)
                    .build()
                    .search();
            Assert.assertNotNull(res);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    public void testIBMImageSearchReturnNotNull() {

        try {
            URL url = new URL("http://1.bp.blogspot.com/-EZ-EdfiRhUc/VU75RcSB8OI/AAAAAAAAC4E/7ouyZ9H-zco/s1600/patata.jpg");
            String key = System.getenv("WATSON_KEY");
            IIBMImageSearchResult res = ReverseImageSearch
                    .getIBMServices(key)
                    .imageSearchBuildQuery()
                    .setImage(url)
                    .build()
                    .search();
            System.out.println(res.toJSONString());
            Assert.assertNotNull(res);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

}