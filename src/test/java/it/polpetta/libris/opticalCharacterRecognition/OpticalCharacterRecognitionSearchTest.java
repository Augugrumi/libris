package it.polpetta.libris.opticalCharacterRecognition;

import it.polpetta.libris.opticalCharacterRecognition.azure.contract.IAzureOcrResult;
import junit.framework.TestCase;
import org.junit.Assert;

import java.net.URL;

/**
 * Created by zanna on 11/05/17.
 */
public class OpticalCharacterRecognitionSearchTest extends TestCase {

    public void testAzureOcrSearchReturnNotNull() {
        try {
            URL url = new URL("http://1.bp.blogspot.com/-EZ-EdfiRhUc/VU75RcSB8OI/AAAAAAAAC4E/7ouyZ9H-zco/s1600/patata.jpg");
            String key = System.getenv("AZURE_KEY");
            IAzureOcrResult res = OpticalCharacterRecognitionSearch
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

}