package com.tfederico.libris.text.discovery.ibm;

import com.ibm.watson.developer_cloud.discovery.v1.model.QueryOptions;
import com.tfederico.libris.text.discovery.contract.IIBMDiscoveryQueryUtility;

public class IBMDiscoveryQueryUtility implements IIBMDiscoveryQueryUtility{
    @Override
    public QueryOptions queryCollection(String envId, String collId, String query) {
        QueryOptions.Builder builder = new QueryOptions.Builder();
        builder.environmentId(envId);
        builder.collectionId(collId);
        builder.naturalLanguageQuery(query);
        return builder.build();
    }
}
