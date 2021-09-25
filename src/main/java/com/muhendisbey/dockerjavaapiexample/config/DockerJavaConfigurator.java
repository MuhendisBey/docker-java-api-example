package com.muhendisbey.dockerjavaapiexample.config;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.BeanProperty;

@Configuration
public class DockerJavaConfigurator
{
    @Bean
    DockerClient getDockerClient()
    {
//        var dockerClientDefaultConfig
//                = DefaultDockerClientConfig.createDefaultConfigBuilder()
//                .withRegistryEmail("info@baeldung.com")
//                .withRegistryPassword("baeldung")
//                .withRegistryUsername("baeldung")
//                .withDockerCertPath("/home/baeldung/.docker/certs")
//                .withDockerConfig("/home/baeldung/.docker/")
//                .withDockerTlsVerify("1")
//                .withDockerHost("tcp://docker.baeldung.com:2376").build();

        var dockerClientDefaultConfig = DefaultDockerClientConfig.createDefaultConfigBuilder()
                                                                .build();
        return DockerClientBuilder
                .getInstance(dockerClientDefaultConfig)
                .build();
    }
}
