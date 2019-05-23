package com.dawei.boot.boothelloword.config;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author by Dawei on 2019/5/6.
 * zookeeper 配置类
 */
@Configuration
public class BootZookeeperConfiguration {


    @Value(value = "${zookeeper.address.url}")
    private String zookeeperAddressUrl;

    @Bean
    public CuratorFramework getCuratorFramework() {
        //重试策略
        RetryPolicy retryPolicy =
            //1000ms指初始化的间隔时间 3是重试次数
            new ExponentialBackoffRetry(1000, 3);

        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(
            zookeeperAddressUrl,
            retryPolicy);
        curatorFramework.start();
        return curatorFramework;
    }



























}