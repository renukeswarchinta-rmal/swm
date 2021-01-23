package com.swm.repository;

import com.swm.entity.POIMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface POIMasterRepository extends JpaRepository<POIMaster,Long> {
    @Query("SELECT p FROM POIMaster p WHERE p.owner_name LIKE ?1%")
    List<POIMaster> search(String keyword);
}
