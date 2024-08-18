package com.suryaenergi.sei.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Proyek")
public class Proyek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama_proyek")
    private String namaProyek;
    @Column(name = "client")
    private String client;
    @Column(name = "tgl_mulai")
    private LocalDateTime tglMulai;
    @Column(name = "tgl_selesai")
    private LocalDateTime tglSelesai;
    @Column(name = "pimpinan_proyek")
    private String pimpinanProyek;
    @Column(name = "keterangan")
    private String keterangan;
    @Column(name = "created_at")
    private Timestamp createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }


    @ManyToOne
    @JoinColumn(name = "lokasi_id")
    private Lokasi lokasi;
}
