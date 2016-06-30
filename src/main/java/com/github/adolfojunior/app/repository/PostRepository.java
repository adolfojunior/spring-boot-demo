package com.github.adolfojunior.app.repository;

import org.springframework.stereotype.Repository;

import com.github.adolfojunior.app.model.PostEntity;

@Repository
public interface PostRepository extends EntityRepository<Long, PostEntity> {
}
