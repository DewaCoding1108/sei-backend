package com.suryaenergi.sei.service;

import com.suryaenergi.sei.dto.LokasiDto;

import java.util.List;

public interface LokasiService {
    LokasiDto createLokasi(LokasiDto lokasiDto);
    LokasiDto getLokasiById(Integer lokasiId);

    List<LokasiDto> getAllLokasi();

    LokasiDto updateLokasi(Integer lokasiId, LokasiDto updatedLokasi);

    void deleteLokasi(Integer lokasiId);
}
