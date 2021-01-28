package com.swm.service;


import com.swm.config.ObjectMapperUtils;
import com.swm.dto.PoiMasterDTO;
import com.swm.entity.POIMaster;
import com.swm.repository.POIMasterCustomRepository;
import com.swm.repository.POIMasterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class POIMasterService {

    @Autowired
    private POIMasterRepository poiMasterRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private POIMasterCustomRepository poiMasterCustomRepository;

    public ResponseEntity<?> updatePOIMasterData(PoiMasterDTO poiMasterDTO) {
        if (poiMasterRepository.findById(poiMasterDTO.getId()).isPresent()) {
            POIMaster poiMaster = modelMapper.map(poiMasterDTO, POIMaster.class);
            POIMaster savedPOIMaster = poiMasterRepository.save(poiMaster);
            return ResponseEntity.ok(savedPOIMaster);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public List<PoiMasterDTO> searchPOIMaster(String ownerName,String holding_no,String plot_no,
                                              String guardian_name,String mobile_number,
                                              String property_address,String cityName,String pinCode,String rfId,
                                              String qrCode,String wardNumber){
        //List<POIMaster> poiMasterEntities = poiMasterRepository.search(ownerName,holding_no,plot_no,guardian_name,mobile_number,
        List<POIMaster> poiMasterEntities = poiMasterCustomRepository.searchByAllFields(ownerName,holding_no,plot_no,guardian_name,mobile_number,
                                                            property_address,cityName,pinCode,rfId,qrCode,wardNumber);
        return ObjectMapperUtils.mapAll(poiMasterEntities,PoiMasterDTO.class);

    }

    public List<PoiMasterDTO> getPOIData(Integer pageNo,Integer pageSize){
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<POIMaster> poiMasterDTOList =  poiMasterRepository.findAll(paging);
        return ObjectMapperUtils.mapAll(poiMasterDTOList.getContent(),PoiMasterDTO.class);
    }

}
