package id.go.kemenkeu.siku.services;

import id.go.kemenkeu.siku.models.Indikator;

import java.util.List;

public interface IndikatorServices {
    Indikator getById(long id);

    List<Indikator> get10or20(int jumlah);
}
