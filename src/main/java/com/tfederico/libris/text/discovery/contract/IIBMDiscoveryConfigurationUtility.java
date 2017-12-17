package com.tfederico.libris.text.discovery.contract;


import com.ibm.watson.developer_cloud.discovery.v1.model.CreateConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.DeleteConfigurationOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.ListConfigurationsOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.UpdateConfigurationOptions;

import javax.security.auth.login.Configuration;
import java.io.FileNotFoundException;
import java.util.List;

public interface IIBMDiscoveryConfigurationUtility {

    CreateConfigurationOptions createConfiguration(String envId, String name, String jsonFile) throws FileNotFoundException;

    UpdateConfigurationOptions updateConfiguration(String envId, String confId,
                                                   String name, String jsonFile) throws FileNotFoundException;

    ListConfigurationsOptions listConfigurations(String envId);

    DeleteConfigurationOptions deleteConfiguration(String envId, String confId);


}
