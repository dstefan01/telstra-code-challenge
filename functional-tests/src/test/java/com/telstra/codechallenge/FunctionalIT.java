package com.telstra.codechallenge;

import com.intuit.karate.junit5.Karate;

public class FunctionalIT {
  @Karate.Test
  Karate testMicroservice() {
    return Karate.run("microservice").relativeTo(getClass());
  }

  @Karate.Test
  Karate testHelloWorld() {
    return Karate.run("helloworld").relativeTo(getClass());
  }

  @Karate.Test
  Karate testQuotes() {
    return Karate.run("quotes").relativeTo(getClass());
  }
  
  @Karate.Test
  Karate testRepositorySearch() {
    return Karate.run("repositories").relativeTo(getClass());
  }
  
  @Karate.Test
  Karate testUserSearch() {
    return Karate.run("users").relativeTo(getClass());
  }

}