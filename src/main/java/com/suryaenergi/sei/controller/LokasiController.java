package com.suryaenergi.sei.controller;

import com.suryaenergi.sei.dto.LokasiDto;
import com.suryaenergi.sei.service.LokasiService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/lokasi")
public class LokasiController {

    private LokasiService lokasiService;

    @PostMapping
    public ResponseEntity<LokasiDto> createLokasi(@RequestBody LokasiDto lokasiDto){
        LokasiDto savedLokasi = lokasiService.createLokasi(lokasiDto);
        return new ResponseEntity<>(savedLokasi, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<LokasiDto> getLokasiById(@PathVariable("id") Integer lokasiId){
        LokasiDto lokasiDto = lokasiService.getLokasiById(lokasiId);
        return ResponseEntity.ok(lokasiDto);
    }
    @GetMapping
    public ResponseEntity<List<LokasiDto>> getAllLokasi(){
        List<LokasiDto> lokasi = lokasiService.getAllLokasi();
        return ResponseEntity.ok(lokasi);
    }

    @PutMapping("{id}")
    public ResponseEntity<LokasiDto> updatedLokasi(@PathVariable("id") Integer lokasiId, @RequestBody LokasiDto updatedLokasi){
        LokasiDto lokasiDto = lokasiService.updateLokasi(lokasiId, updatedLokasi);
        return ResponseEntity.ok(lokasiDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLokasi(@PathVariable("id") Integer lokasiId){
        lokasiService.deleteLokasi(lokasiId);
        return ResponseEntity.ok("Lokasi dengan id: " + lokasiId + " telah berhasil dihapuskan");
    }
}
