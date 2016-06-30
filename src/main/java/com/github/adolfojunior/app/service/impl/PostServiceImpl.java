package com.github.adolfojunior.app.service.impl;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.github.adolfojunior.app.model.PostEntity;
import com.github.adolfojunior.app.repository.PostRepository;
import com.github.adolfojunior.app.service.PostService;

@Service
public class PostServiceImpl implements PostService {

  private PostRepository postRepository;

  @Inject
  public PostServiceImpl(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public Page<PostEntity> findAll(Specification<PostEntity> filter, Pageable pageable) {
    return this.postRepository.findAll(filter, pageable);
  }

  @Override
  public PostEntity get(Long id) {
    return this.postRepository.findOne(id);
  }
}
