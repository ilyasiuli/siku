package id.go.kemenkeu.siku.controllers;

import id.go.kemenkeu.siku.models.Indikator;
import id.go.kemenkeu.siku.models.repositories.IndikatorRepository;
import id.go.kemenkeu.siku.services.IndikatorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    IndikatorServices indikatorServices;


    @GetMapping("/siku/home")
    public String home(){

        Indikator indikator = indikatorServices.getById(1l);
        List<Indikator> indikatorList = indikatorServices.get10or20(10);
        for(Indikator i:indikatorList){
            System.out.println(i.getUraian());
        }

        return "pages/home";
    }
    @GetMapping("/siku/add")
    public String add(){
        Indikator indikator = indikatorServices.getById(1l);
        List<Indikator> indikatorList = indikatorServices.get10or20(20);

        return "pages/home";
    }
}
