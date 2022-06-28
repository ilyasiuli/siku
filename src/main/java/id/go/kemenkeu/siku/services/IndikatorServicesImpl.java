package id.go.kemenkeu.siku.services;

import id.go.kemenkeu.siku.models.Indikator;
import id.go.kemenkeu.siku.models.repositories.IndikatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndikatorServicesImpl implements IndikatorServices{
    @Autowired
    IndikatorRepository indikatorRepository;

    @Override
    public Indikator getById(long id) {
        Optional<Indikator> indikatorOptional = indikatorRepository.findById(id);
        if(indikatorOptional.isPresent()){
            return indikatorOptional.get();
        }
        throw new RuntimeException();
    }

    @Override
    public List<Indikator> get10or20(int jumlah) {
        if(jumlah ==10){
            return indikatorRepository.findIndikator10Row();
        }else if(jumlah ==20){
            return indikatorRepository.findIndikator20Row();
        }else{
            throw new RuntimeException();
        }
    }

    @Override
    public List<Indikator> getAll() {
        return indikatorRepository.findAll();
    }

    @Override
    public void create(Indikator indikator) {
        indikatorRepository.save(indikator);
    }

    @Override
    public Indikator update(Indikator indikator) {
        //Perlu dilakukan pengecekan siapa yang berhak mengupdate indikator tersebut.
        //Misal: PPK1 tidak berhak mengedit paket id 10

        return indikatorRepository.save(indikator);
    }

    @Override
    public boolean delete(Indikator indikator) {
        //Pengecekan apakah user yang login berhak menghapus indikator tersebut.
        //return true, jika berhasil delete
        //return false, jika gagal delete

        indikatorRepository.delete(indikator);
        return true;
    }
}
