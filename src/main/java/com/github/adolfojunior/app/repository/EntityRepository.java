package com.github.adolfojunior.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EntityRepository<ID extends Serializable, T extends AbstractPersistable<ID>>
    extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}
