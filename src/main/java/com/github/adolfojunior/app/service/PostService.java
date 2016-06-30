package com.github.adolfojunior.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.github.adolfojunior.app.model.PostEntity;

public interface PostService {

  Page<PostEntity> search(Specification<PostEntity> filter, Pageable pageable);
}
