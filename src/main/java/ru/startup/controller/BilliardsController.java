package ru.startup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.BilliardsDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.BilliardsService;

@RestController
public class BilliardsController {

    private BilliardsService billiardsService;

    @Autowired
    public void setBilliardsService(BilliardsService billiardsService) {
        this.billiardsService = billiardsService;
    }

    @GetMapping("/api/billiards/{id}")
    public ResponseEntity<BilliardsDTO> getBilliardsById(@PathVariable Long id) {
        if (!billiardsService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(billiardsService.getBilliardsById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/billiards/{id}")
    public ResponseEntity<Void> deleteBilliardsById(@PathVariable Long id) {
        if (!billiardsService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        billiardsService.deleteBilliardsById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/billiards")
    public ResponseEntity<BilliardsDTO> createBilliards(@RequestBody BilliardsDTO billiardsDTO, @RequestParam EntertainmentType entertainmentType) {
        if (billiardsService.existsByName(billiardsDTO.getName())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(billiardsService.createBilliards(billiardsDTO, entertainmentType), HttpStatus.CREATED);
    }
}