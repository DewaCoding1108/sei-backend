package com.suryaenergi.sei.service;

import com.suryaenergi.sei.entity.Lokasi;

import java.util.List;

public interface LokasiService {
    Lokasi createLokasi(Lokasi lokasi);
    Lokasi getLokasiById(Integer lokasiId);

    List<Lokasi> getAllLokasi();

    Lokasi updateLokasi(Integer lokasiId, Lokasi updatedLokasi);

    void deleteLokasi(Integer lokasiId);
}
