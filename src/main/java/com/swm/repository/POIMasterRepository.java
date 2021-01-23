package com.swm.repository;

import com.swm.entity.POIMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface POIMasterRepository extends JpaRepository<POIMasterEntity,Long> {

}
