package com.suryaenergi.sei.controller;

import com.suryaenergi.sei.entity.Lokasi;
import com.suryaenergi.sei.exception.ResourceNotFoundException;
import com.suryaenergi.sei.service.LokasiService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/lokasi")
public class LokasiController {

    private LokasiService lokasiService;

    @GetMapping
    public ResponseEntity<List<Lokasi>> getAllLokasi(){
        return ResponseEntity.ok(lokasiService.getAllLokasi());
    }

    @GetMapping("{id}")
    public ResponseEntity<Lokasi> getLokasiById(@PathVariable("id") Integer lokasiId){
        Lokasi lokasi = lokasiService.getLokasiById(lokasiId);
        return ResponseEntity.ok(lokasi);
    }

    @PostMapping
    public ResponseEntity<Lokasi> createLokasi(@RequestBody Lokasi lokasi){
        Lokasi newLokasi = lokasiService.createLokasi(lokasi);
        return ResponseEntity.ok(newLokasi);
    }



    @PutMapping("{id}")
    public ResponseEntity<Lokasi> updatedLokasi(@PathVariable("id") Integer lokasiId, @RequestBody Lokasi updatedLokasi){
        return ResponseEntity.ok(lokasiService.updateLokasi(lokasiId, updatedLokasi));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLokasi(@PathVariable("id") Integer lokasiId){
        lokasiService.deleteLokasi(lokasiId);
        return ResponseEntity.ok("Lokasi dengan id: " + lokasiId + " telah berhasil dihapuskan");
    }
}
