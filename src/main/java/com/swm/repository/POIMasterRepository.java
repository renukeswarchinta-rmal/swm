package com.swm.repository;

import com.swm.entity.POIMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface POIMasterRepository extends JpaRepository<POIMaster,Long> {
    @Query("SELECT p FROM POIMaster p WHERE p.owner_name LIKE ?1% and p.holding_no LIKE %?2% and p.plot_no LIKE %?3% " +
          "and p.guardian_name like %?4% and p.mobile_number like %?5% and p.property_address like %?6%" +
          "and p.city.cityName like %?7% and p.pinCode.pinCode like %?8% and p.rfId like %?9% " +
          " and p.qrCode like %?10% and p.wardMaster.wardNumber LIKE %?11%")
    List<POIMaster> search(String ownerName,String holding_no,String plot_no,
                           String guardian_name,String mobile_number,
                           String property_address,String cityName,String pinCode,String rfId,
                           String qrCode,String wardNumber);



}
