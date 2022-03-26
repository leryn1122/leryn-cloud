package com.leryn.k8s.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.leryn.common.vo.Result;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Leryn
 * @since Leryn 1.0.0
 */
@RestController
@RequestMapping("/v1")
public class DockerRegistryController {

  @Resource
  private RestTemplate restTemplate;

  /**
   * 查询所有镜像仓库. 直接调用的HTTP接口的方式.
   */
  @GetMapping("/docker/images")
  public Result listImages() {
    ResponseEntity<Map> responseEntity = restTemplate.getForEntity("https://docker.leryn.top/v2/_catalog",
      Map.class);
    List<String> images = ((Map<String, List<String>>) responseEntity.getBody())
      .get("repositories");
    return Result.onSuccess(images);
  }

}
