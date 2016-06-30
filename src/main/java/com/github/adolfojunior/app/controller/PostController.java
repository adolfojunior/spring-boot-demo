package com.github.adolfojunior.app.controller;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.github.adolfojunior.app.model.PostEntity;
import com.github.adolfojunior.framework.jaxrs.PageableBean;

@Path("/post")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface PostController {

  @GET
  Page<PostEntity> search(@BeanParam PageableBean pageableBean);

  @POST
  PostEntity create(PostEntity post);

  @GET
  @Path("/{id}")
  PostEntity get(@PathParam("id") Long id);

  @PUT
  @Path("/{id}")
  PostEntity update(@PathParam("id") Long id, PostEntity post);

  @DELETE
  @Path("/{id}")
  PostEntity delete(@PathParam("id") Long id, PostEntity post);
}
