package ru.startup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.startup.dto.WindTunnelDTO;
import ru.startup.model.entertainment.EntertainmentType;
import ru.startup.service.WindTunnelService;

@RestController
public class WindTunnelController {

    private WindTunnelService windTunnelService;

    @Autowired
    public void setWindTunnelService(WindTunnelService windTunnelService) {
        this.windTunnelService = windTunnelService;
    }

    @GetMapping("/api/wind-tunnel/{id}")
    public ResponseEntity<WindTunnelDTO> getWindTunnelById(@PathVariable Long id){
        if (!windTunnelService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(windTunnelService.getWindTunnelById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/wind-tunnel/{id}")
    public ResponseEntity<Void> deleteWindTunnelById(@PathVariable Long id){
        if (!windTunnelService.existsById(id)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        windTunnelService.deleteWindTunnelById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/wind-tunnel")
    public WindTunnelDTO createWindTunnel(@RequestBody WindTunnelDTO windTunnelDTO, @RequestParam EntertainmentType entertainmentType){
        return windTunnelService.createWindTunnel(windTunnelDTO, entertainmentType);
    }
}
