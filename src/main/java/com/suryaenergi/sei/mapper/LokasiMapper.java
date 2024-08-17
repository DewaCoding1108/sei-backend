package com.suryaenergi.sei.mapper;

import com.suryaenergi.sei.dto.LokasiDto;
import com.suryaenergi.sei.entity.Lokasi;

public class LokasiMapper {
    public static LokasiDto mapToLokasiDto(Lokasi lokasi){
        return new LokasiDto(
                lokasi.getId(),
                lokasi.getNamaLokasi(),
                lokasi.getNegara(),
                lokasi.getProvinsi(),
                lokasi.getKota(),
                lokasi.getCreatedAt()
        );
    }

    public static Lokasi mapToLokasi(LokasiDto lokasiDto){
        return new Lokasi(
                lokasiDto.getId(),
                lokasiDto.getNamaLokasi(),
                lokasiDto.getNegara(),
                lokasiDto.getProvinsi(),
                lokasiDto.getKota(),
                lokasiDto.getCreatedAt()
        );
    }
}
