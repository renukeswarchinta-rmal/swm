package com.swm.repository;

import com.swm.entity.POIMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;

import java.util.List;

@Repository
public interface POIMasterRepository extends JpaRepository<POIMasterEntity,Long> {



    @Query("SELECT p FROM POIMasterEntity p WHERE CONCAT(p.owner_name, p.brand, p.madein, p.price) LIKE %?1%")
    List<POIMasterEntity> search(String keyword);
}
