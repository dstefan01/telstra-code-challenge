package com.telstra.codechallenge.controller.user;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.codechallenge.data.user.UserSearchResponse;
import com.telstra.codechallenge.service.SearchAPIService;

@RestController
@RequestMapping("/user")
public class UserController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Value("${user.base.url}")
	private String url;
	
	@Value("${user.unpopular.query}")
	private String query;

	@Value("${user.unpopular.sort}")
	private String sort;
	
	@Value("${user.unpopular.order}")
	private String order;
	
	@Autowired
	private SearchAPIService searchApi;
	
	@GetMapping("/unpopular")
	public UserSearchResponse getUnpopularUsers(@RequestParam(defaultValue = "10") Integer limit) {
		logger.info("executing search for 'unpopular' users");
		
		return searchApi.executeSearch(url, query, sort, order, limit, UserSearchResponse.class);
	}
}
