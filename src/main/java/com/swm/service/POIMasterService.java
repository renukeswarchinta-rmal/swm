package com.swm.service;


import com.swm.dto.PoiMasterDTO;
import com.swm.entity.POIMasterEntity;
import com.swm.repository.POIMasterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

}
