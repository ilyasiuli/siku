package id.go.kemenkeu.siku.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "indikator")
public class Indikator{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String kode;

    private String uraian;

    private int level;

    @OneToMany(cascade = CascadeType.ALL,
                fetch = FetchType.LAZY,
                mappedBy = "indikator")
    List<Penilaian> penilaianList;

    public String getUraian(){
        return uraian;
    }

}
