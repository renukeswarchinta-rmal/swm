package com.swm.controller;

import com.swm.dto.PoiMasterDTO;
import com.swm.entity.City;
import com.swm.entity.State;
import com.swm.entity.Zone;
import com.swm.repository.CityRepository;
import com.swm.repository.StateRepository;
import com.swm.repository.ZoneRepository;
import com.swm.service.POIMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/poi_master")
public class POIMasterController {



    @Autowired
    private POIMasterService poiMasterService;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private ZoneRepository zoneRepository;
    @Autowired
    private CityRepository cityRepository;


    @PostMapping("/update")
    public ResponseEntity<?> updatePOIMasterData(@RequestBody PoiMasterDTO poiMasterDTO){
        return poiMasterService.updatePOIMasterData(poiMasterDTO);
    }


    @GetMapping("/search")
    public List<PoiMasterDTO> searchPOIMaster(@RequestParam(value = "ownerName", required = false) String ownerName){
            return poiMasterService.searchPOIMaster(ownerName);
    }
    @GetMapping("/test")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok("Testing ");
    }

    @GetMapping("/states")
    public List<State> states(){
        return stateRepository.findAll();
    }

    @GetMapping("/zones")
    public List<Zone> zones(){
        return zoneRepository.findAll();
    }

    @GetMapping("/cities")
    public List<City> cities(){
        return cityRepository.findAll();
    }
}
