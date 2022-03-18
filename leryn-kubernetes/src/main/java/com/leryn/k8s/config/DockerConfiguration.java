package com.leryn.k8s.config;

import java.time.Duration;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@Configuration
public class DockerConfiguration {

  @Data
  @Configuration
  @ConfigurationProperties(prefix = "application.docker")
  public static class DockerProperties {
    private String host;
    private String registryUrl;
    private String certPath;
    private String username;
    private String password;
    private String email;
  }

  @Bean
  public DockerClientConfig dockerClientConfig(DockerProperties properties) {
    DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
      .withDockerHost(properties.getHost())
      .withDockerTlsVerify(false)
//      .withDockerTlsVerify(true)
//      .withDockerCertPath(properties.getCertPath())
      .withRegistryUrl(properties.getRegistryUrl())
      .withRegistryUsername(properties.getUsername())
      .withRegistryPassword(properties.getPassword())
      .withRegistryEmail(properties.getEmail())
      .build();
    return config;
  }

  @Bean
  public DockerHttpClient dockerHttpClient(DockerClientConfig config) {
    DockerHttpClient httpClient = new ApacheDockerHttpClient.Builder()
      .dockerHost(config.getDockerHost())
      .maxConnections(100)
      .connectionTimeout(Duration.ofSeconds(30))
      .responseTimeout(Duration.ofSeconds(30))
      .build();
    return httpClient;
  }

  @Bean
  public DockerClient dockerClient(DockerClientConfig config, DockerHttpClient httpClient) {
    DockerClient dockerClient = DockerClientImpl.getInstance(config, httpClient);
    return dockerClient;
  }

}
