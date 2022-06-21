package id.go.kemenkeu.siku.controllers;

import id.go.kemenkeu.siku.models.Indikator;
import id.go.kemenkeu.siku.models.repositories.IndikatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    IndikatorRepository indikatorRepository;

    @GetMapping("/siku/home")
    public String home(){
        Optional<Indikator> indikatorOptional = indikatorRepository.findById(1l);

        if(indikatorOptional.isPresent()){
            System.out.println(indikatorOptional.get().getUraian());
        }

        Indikator i2 = indikatorRepository.findIndikatorByUraian("C20");
        System.out.println(i2.getUraian());





        return "pages/home";
    }
    @GetMapping("/siku/add")
    public String add(){
        return "pages/home";
    }
}
