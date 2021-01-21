package com.swm.controller;

import com.swm.dto.PoiMasterDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/poi_master")
public class POIMasterController {

    @PostMapping("")
    public ResponseEntity<?> updatePOIMasterData(@RequestBody PoiMasterDTO poiMasterDTO){
        return ResponseEntity.ok("Updated successfully");
    }

    @GetMapping("/test")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok("Testing ");
    }

}
