package id.go.kemenkeu.siku.services;

import id.go.kemenkeu.siku.models.Indikator;
import id.go.kemenkeu.siku.models.repositories.IndikatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
}
