package com.sunnyphotography.www.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunnyphotography.www.entity.Sentity;

@Repository
public interface Srepo extends JpaRepository<Sentity, Long> {
}