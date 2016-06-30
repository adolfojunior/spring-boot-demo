package com.github.adolfojunior.framework.jaxrs;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

public class PageableBean {

  @DefaultValue("0")
  @QueryParam("page")
  private int page;

  @DefaultValue("50")
  @QueryParam("size")
  private int size;

  @QueryParam("order")
  private String properties;

  @QueryParam("dir")
  private Direction direction;

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getProperties() {
    return properties;
  }

  public void setProperties(String properties) {
    this.properties = properties;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public Pageable toPageable() {
    if (this.properties != null) {
      return new PageRequest(this.page, this.size, this.direction, this.properties);
    }
    return new PageRequest(this.page, this.size);
  }
}
