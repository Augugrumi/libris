package com.tfederico.libris.text.discovery.contract;

import com.ibm.watson.developer_cloud.discovery.v1.model.QueryOptions;

public interface IIBMDiscoveryQueryUtility {

    QueryOptions queryCollection(String envId, String collId, String query);

}
