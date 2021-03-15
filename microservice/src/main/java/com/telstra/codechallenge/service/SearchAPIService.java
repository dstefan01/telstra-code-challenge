package com.telstra.codechallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SearchAPIService {

  @Autowired private RestTemplate restTemplate;

  public <T> T executeSearch(
      String url, String query, String sort, String order, int limit, Class<T> clazz) {

    UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("q", query)
            .queryParam("sort", sort)
            .queryParam("order", order)
            .queryParam("per_page", limit);

    ResponseEntity<T> response;

    try {
      response =
          restTemplate.exchange(
              builder.build(true).toUri(),
              HttpMethod.GET,
              null,
              clazz);
      if (!response.getStatusCode().is2xxSuccessful()) {
        throw new ResponseStatusException(
            response.getStatusCode(), "Server returned with unsuccesful response");
      }
    } catch (Exception e) {
      throw e;
    }

    return response.getBody();
  }
}
