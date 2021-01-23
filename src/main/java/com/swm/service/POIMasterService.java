package com.swm.service;


import com.swm.dto.PoiMasterDTO;
import com.swm.entity.POIMasterEntity;
import com.swm.repository.POIMasterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
        if (poiMasterRepository.findById(poiMasterDTO.getPoi_id()).isPresent()) {
            POIMasterEntity poiMasterEntity = modelMapper.map(poiMasterDTO, POIMasterEntity.class);
            POIMasterEntity savedPOIMaster = poiMasterRepository.save(poiMasterEntity);
            return ResponseEntity.ok(savedPOIMaster);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public List<PoiMasterDTO> searchPOIMaster(String name){
        List<POIMasterEntity> poiMasterEntities = poiMasterRepository.search(name);
        return poiMasterEntities.stream().map(poiMasterEntity -> modelMapper.map(poiMasterEntity,PoiMasterDTO.class))
                                  .collect(Collectors.toList());
    }

}
