package com.thepracticaldeveloper.eurekaclient.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Profile("spanish")
public class HolaController {

  private final RestTemplate restTemplate;
  private final EurekaClient discoveryClient;
  private final String englishVirtualAlias;

  public HolaController(final RestTemplate restTemplate,
                        final EurekaClient discoveryClient,
                        @Value("${tpd.appconfig.english-alias}") final String englishVirtualAlias) {
    this.restTemplate = restTemplate;
    this.discoveryClient = discoveryClient;
    this.englishVirtualAlias = englishVirtualAlias;
  }

  @GetMapping("/hola-server")
  public String holaServer() {
    return "Hola desde el cliente en Español!";
  }

  @GetMapping("/hola")
  public String hola() {
    final InstanceInfo instance = discoveryClient.getNextServerFromEureka(englishVirtualAlias, false);
    final String theOtherResponse = restTemplate.getForObject(instance.getHomePageUrl() + "/hello-server", String.class);
    return holaServer() + " My English peer says: " + theOtherResponse;
  }
}
