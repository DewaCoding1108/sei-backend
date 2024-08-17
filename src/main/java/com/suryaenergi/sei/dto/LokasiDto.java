package com.suryaenergi.sei.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LokasiDto {
    private Integer id;
    private String namaLokasi;
    private String negara;
    private String provinsi;
    private String kota;
    private Timestamp createdAt;
}
