package com.tfederico.libris.text.discovery.ibm;

import com.ibm.watson.developer_cloud.discovery.v1.Discovery;
import com.ibm.watson.developer_cloud.discovery.v1.model.*;
import com.tfederico.libris.text.discovery.contract.*;

import java.io.FileNotFoundException;
import java.util.List;

public class IBMDiscoveryUtility implements IIBMDiscoveryUtility{

    private static String apiKey;

    private Discovery discovery;

    private IIBMDiscoveryEnvironmentUtility environmentUtility;

    private IIBMDiscoveryConfigurationUtility configurationUtility;

    private IIBMDiscoveryCollectionUtility collectionUtility;

    private IIBMDiscoveryDocumentUtility documentUtility;

    private IIBMDiscoveryQueryUtility queryUtility;

    public IBMDiscoveryUtility(){
        discovery = new Discovery("2017-11-07");
        discovery.setApiKey(apiKey);
        environmentUtility = new IBMDiscoveryEnvironmentUtility();
        configurationUtility = new IBMDiscoveryConfigurationUtility();
        collectionUtility = new IBMDiscoveryCollectionUtility();
        documentUtility = new IBMDiscoveryDocumentUtility();
        queryUtility = new IBMDiscoveryQueryUtility();
    }

    public static void setApiKey(String key){
        apiKey = key;
    }

    @Override
    public Environment createEnvironment(String name, String description) {
        CreateEnvironmentOptions options = environmentUtility.createEnvironment(name, description);
        return discovery.createEnvironment(options).execute();
    }

    @Override
    public List<Environment> listEnvironments() {
        return discovery.listEnvironments().execute().getEnvironments();
    }

    @Override
    public Environment updateEnvironment(String envId, String name, String description) {

        UpdateEnvironmentOptions options = environmentUtility.updateEnvironment(envId,
                name, description);

        return discovery.updateEnvironment(options).execute();
    }

    @Override
    public void deleteEnvironment(String envId) {

        DeleteEnvironmentOptions options = environmentUtility.deleteEnvironment(envId);

        discovery.deleteEnvironment(options);
    }

    @Override
    public Configuration createConfiguration(String envId, String name, String jsonFile) throws FileNotFoundException {
        CreateConfigurationOptions options = configurationUtility.createConfiguration(envId, name, jsonFile);
        return discovery.createConfiguration(options).execute();
    }

    @Override
    public Configuration updateConfiguration(String envId, String confId, String name, String jsonFile) throws FileNotFoundException {
        UpdateConfigurationOptions options = configurationUtility.updateConfiguration(envId, confId, name, jsonFile);
        return discovery.updateConfiguration(options).execute();
    }

    @Override
    public List<Configuration> listConfigurations(String envId) {
        ListConfigurationsOptions options = configurationUtility.listConfigurations(envId);
        return discovery.listConfigurations(options).execute().getConfigurations();
    }

    @Override
    public void deleteConfiguration(String envId, String confId) {
        DeleteConfigurationOptions options = configurationUtility.deleteConfiguration(envId, confId);
        discovery.deleteConfiguration(options).execute();
    }

    @Override
    public Collection createCollection(String envId, String confId, String name, String description, String lang) {
        CreateCollectionOptions options = collectionUtility.createCollection(envId, confId, name, description, lang);
        return discovery.createCollection(options).execute();
    }

    @Override
    public List<Collection> listCollections(String envId) {
        ListCollectionsOptions options = collectionUtility.listCollections(envId);
        return discovery.listCollections(options).execute().getCollections();
    }

    @Override
    public Collection updateCollection(String envId, String confId, String collId, String name, String description) {
        UpdateCollectionOptions options = collectionUtility.updateCollection(envId, confId, collId, name, description);
        return discovery.updateCollection(options).execute();
    }

    @Override
    public void deleteCollection(String envId, String collId) {
        DeleteCollectionOptions options = collectionUtility.deleteCollection(envId, collId);
        discovery.deleteCollection(options).execute();
    }

    @Override
    public DocumentAccepted addDocument(String envId, String collId, String jsonPath) throws FileNotFoundException {
        AddDocumentOptions options = documentUtility.addDocument(envId, collId, jsonPath);
        return discovery.addDocument(options).execute();
    }

    @Override
    public DocumentAccepted updateDocument(String envId, String collId, String docId, String jsonPath) throws FileNotFoundException {
        UpdateDocumentOptions options = documentUtility.updateDocument(envId, collId, docId, jsonPath);
        return discovery.updateDocument(options).execute();
    }

    @Override
    public void deleteDocument(String envId, String collId, String docId) {
        DeleteDocumentOptions options = documentUtility.deleteDocument(envId, collId, docId);
        discovery.deleteDocument(options).execute();
    }

    @Override
    public QueryResponse queryCollection(String envId, String collId, String query) {
        QueryOptions options = queryUtility.queryCollection(envId, collId, query);
        return discovery.query(options).execute();
    }
}
