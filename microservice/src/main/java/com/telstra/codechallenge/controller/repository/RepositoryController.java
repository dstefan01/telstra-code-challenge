package com.telstra.codechallenge.controller.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.codechallenge.data.repository.RepositorySearchResponse;
import com.telstra.codechallenge.service.SearchAPIService;

@RestController
@RequestMapping("/repository")
public class RepositoryController {
  @Value("${repository.base.url}")
  private String reposBaseUrl;

  @Value("${repository.popular.query}")
  private String query;

  @Value("${repository.popular.sort}")
  private String sort;

  @Value("${repository.popular.order}")
  private String order;

  @Autowired private SearchAPIService searchApiService;

  @GetMapping("/popular")
  public RepositorySearchResponse getPopular(@RequestParam(defaultValue = "10") Integer limit) {

	  RepositorySearchResponse resp = searchApiService.executeSearch(
		        reposBaseUrl,
		        String.format(query, getDatePastWeek()),
		        sort,
		        order,
		        limit,
		        RepositorySearchResponse.class);
    return resp;
  }

  public String getDatePastWeek() {
    return LocalDate.now().minusDays(7).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
  }
}
