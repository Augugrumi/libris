package com.tfederico.libris.text.discovery.contract;

import com.ibm.watson.developer_cloud.discovery.v1.model.*;

public interface IIBMDiscoveryCollectionUtility {

    CreateCollectionOptions createCollection(String envId, String confId,
                                             String name, String description, String lang);

    ListCollectionsOptions listCollections(String envId);

    UpdateCollectionOptions updateCollection(String envId, String confId, String collId,
                                             String name, String description);

    DeleteCollectionOptions deleteCollection(String envId, String collId);
}
