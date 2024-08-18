package com.suryaenergi.sei.service.impl;

import com.suryaenergi.sei.entity.Proyek;
import com.suryaenergi.sei.exception.ResourceNotFoundException;
import com.suryaenergi.sei.repository.ProyekRepository;
import com.suryaenergi.sei.service.ProyekService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProyekServiceImpl implements ProyekService {
    private ProyekRepository proyekRepository;
    @Override
    public Proyek createProyek(Proyek proyek) {
        return proyekRepository.save(proyek);
    }

    @Override
    public Proyek getProyekById(Integer proyekId) {
        return proyekRepository.findById(proyekId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Proyek dengan id: " + proyekId + " tidak ditemukan"));
    }

    @Override
    public List<Proyek> getAllProyek() {
        return proyekRepository.findAll();
    }

    @Override
    public Proyek updateProyek(Integer proyekId, Proyek updatedProyek) {
        Proyek proyek = proyekRepository.findById(proyekId).orElseThrow(()->
                new ResourceNotFoundException("Proyek dengan id: " + proyekId + " tidak ditemukan"));
        proyek.setNamaProyek(updatedProyek.getNamaProyek());
        proyek.setClient(updatedProyek.getClient());
        proyek.setTglMulai(updatedProyek.getTglMulai());
        proyek.setTglSelesai(updatedProyek.getTglSelesai());
        proyek.setPimpinanProyek(updatedProyek.getPimpinanProyek());
        proyek.setKeterangan(updatedProyek.getKeterangan());
        proyek.setLokasi(updatedProyek.getLokasi());
        return proyekRepository.save(proyek);
    }

    @Override
    public void deleteProyek(Integer proyekId) {
        proyekRepository.deleteById(proyekId);
    }
}
