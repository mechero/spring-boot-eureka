package com.thepracticaldeveloper.eurekaclient.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Profile("english")
public class HelloController {

  private final RestTemplate restTemplate;
  private final EurekaClient discoveryClient;
  private final String spanishVirtualAlias;

  public HelloController(final RestTemplate restTemplate,
                        final EurekaClient discoveryClient,
                        @Value("${tpd.appconfig.spanish-alias}") final String spanishVirtualAlias) {
    this.restTemplate = restTemplate;
    this.discoveryClient = discoveryClient;
    this.spanishVirtualAlias = spanishVirtualAlias;
  }

  @GetMapping("/hello-server")
  public String helloServer() {
    return "Hello from the English client!";
  }

  @GetMapping("/hello")
  public String hello() {
    final InstanceInfo instance = discoveryClient.getNextServerFromEureka(spanishVirtualAlias, false);
    final String theOtherResponse = restTemplate.getForObject(instance.getHomePageUrl() + "/hola-server", String.class);
    return helloServer() + " Mi colega español dice: " + theOtherResponse;
  }
}
