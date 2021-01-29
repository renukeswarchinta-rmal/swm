package com.swm.repository;

import com.swm.entity.POIMaster;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface POIMasterCustomRepository {

    List<POIMaster> searchByAllFields(String ownerName, String holding_no, String plot_no,
                                      String guardian_name, String mobile_number,
                                      String property_address, String cityName, String pinCode, String rfId,
                                      String qrCode, String wardNumber,Integer pageNo,Integer pageSize);
}
