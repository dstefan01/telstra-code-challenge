package com.telstra.codechallenge.data.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSearchResponse {
  private List<UserItem> items;

  public List<UserItem> getItems() {
    return items;
  }

  public void setItems(List<UserItem> items) {
    this.items = items;
  }
}
