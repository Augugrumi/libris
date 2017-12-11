package com.tfederico.libris.opticalCharacterRecognition;

import com.tfederico.libris.opticalCharacterRecognition.azure.contract.IAzureOcrResult;
import junit.framework.TestCase;
import org.junit.Assert;

import java.net.URL;

/**
 * Created by zanna on 11/05/17.
 */
public class OpticalCharacterRecognitionSearchTest extends TestCase {

    public void testAzureOcrSearchReturnNotNull() {
        try {
            URL url = new URL("https://i.ytimg.com/vi/0E4PWHTS4BA/hqdefault.jpg");
            String key = System.getenv("AZURE_KEY");
            IAzureOcrResult res = OpticalCharacterRecognitionSearch
                    .getAzureServices(key)
                    .imageSearchBuildQuery()
                    .setImage(url)
                    .build()
                    .search();
            org.junit.Assert.assertNotNull(res);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    /*public void testIBMOcrSearchReturnNotNull() {
        try {
            URL url = new URL("https://onepagelove-wpengine.netdna-ssl.com/wp-content/uploads/2016/10/opl-small-1.jpg");
            String key = System.getenv("WATSON_KEY");
            IIBMOcrResult res = OpticalCharacterRecognitionSearch
                    .getIBMServices(key)
                    .imageSearchBuildQuery()
                    .setImage(url)
                    .build()
                    .search();
            System.out.println(res.toJSONString());
            org.junit.Assert.assertNotNull(res);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }*/

}