package com.suryaenergi.sei.controller;

import com.suryaenergi.sei.entity.Proyek;
import com.suryaenergi.sei.service.ProyekService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/proyek")
public class ProyekController {
    private ProyekService proyekService;

    @PostMapping
    public ResponseEntity<Proyek> createProyek(@RequestBody Proyek proyekDto){
        Proyek savedProyek = proyekService.createProyek(proyekDto);
        return new ResponseEntity<>(savedProyek, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Proyek> getProyekById(@PathVariable("id") Integer proyekId){
        Proyek proyek = proyekService.getProyekById(proyekId);
        return ResponseEntity.ok(proyek);
    }
    @GetMapping
    public ResponseEntity<List<Proyek>> getAllProyek(){
        List<Proyek> proyek = proyekService.getAllProyek();
        return ResponseEntity.ok(proyek);
    }

    @PutMapping("{id}")
    public ResponseEntity<Proyek> updatedProyek(@PathVariable("id") Integer proyekId, @RequestBody Proyek updatedProyek){
        Proyek proyek = proyekService.updateProyek(proyekId, updatedProyek);
        return ResponseEntity.ok(proyek);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProyek(@PathVariable("id") Integer proyekId){
        proyekService.deleteProyek(proyekId);
        return ResponseEntity.ok("Proyek dengan id: " + proyekId + " telah berhasil dihapuskan");
    }
}
