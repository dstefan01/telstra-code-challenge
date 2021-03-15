package com.telstra.codechallenge.data.repository;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositorySearchResponse {
  private List<RepositoryItem> items;

  public List<RepositoryItem> getItems() {
    return items;
  }

  public void setItems(List<RepositoryItem> items) {
    this.items = items;
  }
}
