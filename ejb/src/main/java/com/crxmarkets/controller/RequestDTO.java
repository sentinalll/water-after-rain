package com.crxmarkets.controller;

import java.util.List;

public class RequestDTO {

  private List<Integer> list;

  public List<Integer> getList() {
    return list;
  }

  public void setList(List<Integer> list) {
    this.list = list;
  }

  @Override
  public String toString() {
    return "RequestDTO{" +
        "list=" + list +
        '}';
  }
}
