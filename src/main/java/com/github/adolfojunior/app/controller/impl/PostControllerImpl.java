package com.github.adolfojunior.app.controller.impl;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import com.github.adolfojunior.app.controller.PostController;
import com.github.adolfojunior.app.model.PostEntity;
import com.github.adolfojunior.app.service.PostService;
import com.github.adolfojunior.framework.jaxrs.PageableBean;

@Controller
public class PostControllerImpl implements PostController {

  private PostService postService;

  @Inject
  public PostControllerImpl(PostService postService) {
    this.postService = postService;
  }

  @Override
  public Page<PostEntity> search(PageableBean pageableBean) {
    return postService.findAll(null, pageableBean.toPageable());
  }

  @Override
  public PostEntity create(PostEntity post) {
    return null;
  }

  @Override
  public PostEntity get(Long id) {
    return postService.get(id);
  }

  @Override
  public PostEntity update(Long id, PostEntity post) {
    return null;
  }

  @Override
  public PostEntity delete(Long id, PostEntity post) {
    return null;
  }
}
