package com.swm.service;


import com.swm.config.ObjectMapperUtils;
import com.swm.dto.PoiMasterDTO;
import com.swm.entity.POIMaster;
import com.swm.repository.POIMasterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    public ResponseEntity<?> updatePOIMasterData(PoiMasterDTO poiMasterDTO) {
        if (poiMasterRepository.findById(poiMasterDTO.getId()).isPresent()) {
            POIMaster poiMaster = modelMapper.map(poiMasterDTO, POIMaster.class);
            POIMaster savedPOIMaster = poiMasterRepository.save(poiMaster);
            return ResponseEntity.ok(savedPOIMaster);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public List<PoiMasterDTO> searchPOIMaster(String name){
        List<POIMaster> poiMasterEntities = poiMasterRepository.search(name);
        return ObjectMapperUtils.mapAll(poiMasterEntities,PoiMasterDTO.class);

    }

    public List<PoiMasterDTO> getPOIData(){
        List<POIMaster> poiMasterDTOList =  poiMasterRepository.findAll();
        return ObjectMapperUtils.mapAll(poiMasterDTOList,PoiMasterDTO.class);
    }

}
