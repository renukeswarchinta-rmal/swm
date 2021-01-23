package com.swm.controller;

import com.swm.dto.PoiMasterDTO;
import com.swm.entity.POIMasterEntity;
import com.swm.repository.POIMasterRepository;
import com.swm.service.POIMasterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/poi_master")
public class POIMasterController {



    @Autowired
    private POIMasterService poiMasterService;


    @PostMapping("/update")
    public ResponseEntity<?> updatePOIMasterData(@RequestBody PoiMasterDTO poiMasterDTO){
        return poiMasterService.updatePOIMasterData(poiMasterDTO);
    }


    @GetMapping
    public List<PoiMasterDTO> searchPOIMaster(@RequestParam(value = "name", required = false) String name){
            return poiMasterService.searchPOIMaster(name);
    }
    @GetMapping("/test")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok("Testing ");
    }

}
