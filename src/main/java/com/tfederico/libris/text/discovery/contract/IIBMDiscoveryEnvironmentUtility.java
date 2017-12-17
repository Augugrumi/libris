package com.tfederico.libris.text.discovery.contract;

import com.ibm.watson.developer_cloud.discovery.v1.model.*;

import java.util.List;

public interface IIBMDiscoveryEnvironmentUtility {
    CreateEnvironmentOptions createEnvironment(String name, String description);

    UpdateEnvironmentOptions updateEnvironment(String envId, String name, String description);

    DeleteEnvironmentOptions deleteEnvironment(String envId);
}
