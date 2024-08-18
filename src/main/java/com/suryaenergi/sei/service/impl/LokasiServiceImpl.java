package com.suryaenergi.sei.service.impl;

import com.suryaenergi.sei.entity.Lokasi;
import com.suryaenergi.sei.exception.ResourceNotFoundException;
import com.suryaenergi.sei.repository.LokasiRepository;
import com.suryaenergi.sei.service.LokasiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LokasiServiceImpl implements LokasiService {
    private LokasiRepository lokasiRepository;
    @Override
    public Lokasi createLokasi(Lokasi lokasi) {
        return lokasiRepository.save(lokasi);
    }

    @Override
    public Lokasi getLokasiById(Integer lokasiId) {
        return lokasiRepository.findById(lokasiId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Lokasi dengan id: " + lokasiId + " tidak ditemukan"));
    }

    @Override
    public List<Lokasi> getAllLokasi() {
        return lokasiRepository.findAll();
    }

    @Override
    public Lokasi updateLokasi(Integer lokasiId, Lokasi updatedLokasi) {
        Lokasi lokasi = lokasiRepository.findById(lokasiId).orElseThrow(()->
                new ResourceNotFoundException("Lokasi dengan id: " + lokasiId + " tidak ditemukan"));
        lokasi.setNamaLokasi(updatedLokasi.getNamaLokasi());
        lokasi.setNegara(updatedLokasi.getNegara());
        lokasi.setProvinsi(updatedLokasi.getProvinsi());
        lokasi.setKota(updatedLokasi.getKota());
        return lokasiRepository.save(lokasi);
    }

    @Override
    public void deleteLokasi(Integer lokasiId) {
        lokasiRepository.deleteById(lokasiId);
    }
}
