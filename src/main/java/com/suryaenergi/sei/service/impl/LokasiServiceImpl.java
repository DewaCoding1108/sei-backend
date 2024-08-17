package com.suryaenergi.sei.service.impl;

import com.suryaenergi.sei.dto.LokasiDto;
import com.suryaenergi.sei.entity.Lokasi;
import com.suryaenergi.sei.exception.ResourceNotFoundException;
import com.suryaenergi.sei.mapper.LokasiMapper;
import com.suryaenergi.sei.repository.LokasiRepository;
import com.suryaenergi.sei.service.LokasiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LokasiServiceImpl implements LokasiService {
    private LokasiRepository lokasiRepository;
    @Override
    public LokasiDto createLokasi(LokasiDto lokasiDto) {
        Lokasi lokasi = LokasiMapper.mapToLokasi(lokasiDto);
        Lokasi savedLokasi = lokasiRepository.save(lokasi);
        return LokasiMapper.mapToLokasiDto(savedLokasi);
    }

    @Override
    public LokasiDto getLokasiById(Integer lokasiId) {
        Lokasi lokasi = lokasiRepository.findById(lokasiId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Lokasi dengan id: " + lokasiId + " tidak ditemukan"));
        return LokasiMapper.mapToLokasiDto(lokasi);
    }

    @Override
    public List<LokasiDto> getAllLokasi() {
        List<Lokasi> lokasi = lokasiRepository.findAll();
        return lokasi.stream().map((l) -> LokasiMapper.mapToLokasiDto(l))
                .collect(Collectors.toList());
    }

    @Override
    public LokasiDto updateLokasi(Integer lokasiId, LokasiDto updatedLokasi) {
        Lokasi lokasi = lokasiRepository.findById(lokasiId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Lokasi dengan id: " + lokasiId + " tidak ditemukan"));
        lokasi.setNamaLokasi(updatedLokasi.getNamaLokasi());
        lokasi.setNegara(updatedLokasi.getNegara());
        lokasi.setProvinsi(updatedLokasi.getProvinsi());
        lokasi.setKota(updatedLokasi.getKota());
        Lokasi updatedLokasiObj = lokasiRepository.save(lokasi);
        return LokasiMapper.mapToLokasiDto(updatedLokasiObj);
    }

    @Override
    public void deleteLokasi(Integer lokasiId) {
        Lokasi lokasi = lokasiRepository.findById(lokasiId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Lokasi dengan id: " + lokasiId + " tidak ditemukan"));
        lokasiRepository.deleteById(lokasiId);
    }
}
