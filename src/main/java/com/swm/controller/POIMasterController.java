package com.swm.controller;

import com.swm.dto.PoiMasterDTO;
import com.swm.entity.*;
import com.swm.repository.CityRepository;
import com.swm.repository.StateRepository;
import com.swm.repository.ZoneRepository;
import com.swm.service.POIMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
    public List<PoiMasterDTO> searchPOIMaster(@RequestParam(value = "ownerName", required = false) String ownerName,
                                              @RequestParam(value = "holding_no", required = false) String holding_no,
                                              @RequestParam(value = "plot_no", required = false) String plot_no,
                                              @RequestParam(value = "guardian_name", required = false) String guardian_name,
                                              @RequestParam(value = "mobile_number", required = false) String mobile_number,
                                              @RequestParam(value = "property_address", required = false) String property_address,
                                              @RequestParam(value = "cityName", required = false) String cityName,
                                              @RequestParam(value = "pinCode", required = false) String pinCode,
                                              @RequestParam(value = "rfId", required = false) String rfId,
                                              @RequestParam(value = "qrCode", required = false) String qrCode,
                                              @RequestParam(value = "wardNumber", required = false) String wardNumber,
                                              @RequestParam(defaultValue = "0") Integer pageNo,
                                              @RequestParam(defaultValue = "10") Integer pageSize
                                              ){
            return poiMasterService.searchPOIMaster(ownerName,holding_no,plot_no,guardian_name,mobile_number,
                property_address,cityName,pinCode,rfId,qrCode,wardNumber,pageNo,pageSize);
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

    @GetMapping("/poimasterdata")
    public ResponseEntity<List<PoiMasterDTO>> poiData(
        @RequestParam(defaultValue = "0") Integer pageNo,
        @RequestParam(defaultValue = "10") Integer pageSize
    ){
        List<PoiMasterDTO> poiMasterDTOList = poiMasterService.getPOIData(pageNo,pageSize);
        return new ResponseEntity<List<PoiMasterDTO>>(poiMasterDTOList,new HttpHeaders(), HttpStatus.OK);

    }
}
