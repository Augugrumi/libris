package com.tfederico.libris.text.discovery.ibm;

import com.ibm.watson.developer_cloud.discovery.v1.model.*;
import com.tfederico.libris.text.discovery.contract.IIBMDiscoveryCollectionUtility;

import java.util.List;

public class IBMDiscoveryCollectionUtility implements IIBMDiscoveryCollectionUtility{
    @Override
    public CreateCollectionOptions createCollection(String envId, String confId,
                                                    String name, String description, String lang) {
        CreateCollectionOptions.Builder builder = new CreateCollectionOptions.Builder();
        builder.environmentId(envId);
        builder.configurationId(confId);
        builder.name(name);
        builder.language(lang);
        builder.description(description);
        return builder.build();
    }

    @Override
    public ListCollectionsOptions listCollections(String envId) {
        ListCollectionsOptions.Builder builder = new ListCollectionsOptions.Builder();
        builder.environmentId(envId);
        return builder.build();
    }

    @Override
    public UpdateCollectionOptions updateCollection(String envId, String confId, String collId,
                                                    String name, String description) {
        UpdateCollectionOptions.Builder builder = new UpdateCollectionOptions.Builder();
        builder.environmentId(envId);
        builder.configurationId(confId);
        builder.collectionId(collId);
        builder.name(name);
        builder.description(description);
        return builder.build();
    }

    @Override
    public DeleteCollectionOptions deleteCollection(String envId, String collId) {
        DeleteCollectionOptions.Builder builder = new DeleteCollectionOptions.Builder();
        builder.environmentId(envId);
        builder.collectionId(collId);
        return builder.build();
    }
}
