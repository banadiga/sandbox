package com.banadiga.caching;

import com.banadiga.caching.dto.Item;
import com.banadiga.caching.serializer.ItemKryoSerializer;
import com.hazelcast.config.Config;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.config.SerializerConfig;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IQueue;
import com.hazelcast.core.ITopic;
import com.hazelcast.core.ItemListener;
import com.hazelcast.core.MessageListener;
import com.hazelcast.spring.cache.HazelcastCacheManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfiguration {

  @Bean
  public ManagementCenterConfig managementCenterConfig(
      @Value("${hazelcast.managementCenter:}") String managementCenter) {
    ManagementCenterConfig managementCenterConfig = new ManagementCenterConfig(managementCenter, 1);
    managementCenterConfig.setEnabled(true);
    return managementCenterConfig;
  }

  @Bean
  public GroupConfig groupConfig(
      @Value("${hazelcast.groupConfig.user:}") String groupConfigUser,
      @Value("${hazelcast.groupConfig.password:}") String groupConfigPassword) {
    return new GroupConfig(groupConfigUser, groupConfigPassword);
  }

  @Bean
  public SerializerConfig itemSerialize(ItemKryoSerializer itemKryoSerializer) {
    return new SerializerConfig().setTypeClass(Item.class).setImplementation(itemKryoSerializer);
  }

  @Bean
  public Config config(ManagementCenterConfig managementCenterConfig, GroupConfig groupConfig,
                       List<SerializerConfig> serializerConfigs,
                       @Value("${hazelcast.licenseKey:}") String licenseKey) {
    Config config = new XmlConfigBuilder().build();

    config.setManagementCenterConfig(managementCenterConfig);
    config.setGroupConfig(groupConfig);

    config.getSerializationConfig().getSerializerConfigs().addAll(serializerConfigs);

    config.setLicenseKey(licenseKey);
    return config;
  }

  @Bean
  public HazelcastInstance hazelcastInstance(Config config) throws Exception {
    return Hazelcast.newHazelcastInstance(config);
  }

  @Bean
  public CacheManager itemsCache(HazelcastInstance hazelcastInstance) {
    return new HazelcastCacheManager(hazelcastInstance);
  }

  @Bean
  public IMap<String, Item> storage(HazelcastInstance hazelcastInstance) {
    return hazelcastInstance.getMap("Items");
  }

  @Bean
  public IQueue<String> queue(HazelcastInstance hazelcastInstance, List<ItemListener<String>> eventListeners) {
    IQueue<String> queue = hazelcastInstance.getQueue("queue");
    eventListeners.forEach(stringItemListener -> queue.addItemListener(stringItemListener, true));
    return queue;
  }

  @Bean
  public ITopic<String> event(HazelcastInstance hazelcastInstance, List<MessageListener<String>> messageListeners) {
    ITopic<String> topic = hazelcastInstance.getTopic("event");
    messageListeners.forEach(topic::addMessageListener);
    return topic;
  }
}
