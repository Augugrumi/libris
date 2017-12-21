package com.tfederico.libris.text.discovery.contract;

import com.ibm.watson.developer_cloud.discovery.v1.model.*;

import javax.swing.text.Document;
import java.io.FileNotFoundException;
import java.util.List;

public interface IIBMDiscoveryUtility {

    Environment createEnvironment(String name, String description);

    List<Environment> listEnvironments();

    Environment updateEnvironment(String envId, String name, String description);

    void deleteEnvironment(String envId);

    Configuration createConfiguration(String envId, String name, String jsonFile) throws FileNotFoundException;

    Configuration updateConfiguration(String envId, String confId,
                                                   String name, String jsonFile) throws FileNotFoundException;

    List<Configuration> listConfigurations(String envId);

    void deleteConfiguration(String envId, String confId);

    Collection createCollection(String envId, String confId,
                                String name, String description, String lang);

    List<Collection> listCollections(String envId);

    Collection updateCollection(String envId, String confId, String collId,
                                             String name, String description);

    void deleteCollection(String envId, String collId);

    DocumentAccepted addDocument(String envId, String collId, String jsonPath) throws FileNotFoundException;

    DocumentAccepted updateDocument(String envId, String collId, String docId, String jsonPath) throws FileNotFoundException;

    void deleteDocument(String envId, String collId, String docId);

    QueryResponse queryCollection(String envId, String collId, String query);
}
