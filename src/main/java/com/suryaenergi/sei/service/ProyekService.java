package com.suryaenergi.sei.service;


import com.suryaenergi.sei.entity.Proyek;

import java.util.List;

public interface ProyekService {
    Proyek createProyek(Proyek proyek);
    Proyek getProyekById(Integer proyekId);

    List<Proyek> getAllProyek();

    Proyek updateProyek(Integer proyekId, Proyek updatedProyek);

    void deleteProyek(Integer proyekId);
}
