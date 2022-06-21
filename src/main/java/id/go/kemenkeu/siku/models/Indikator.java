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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getUraian() {
        return "Uraiannya adalah "+uraian;
    }

    public void setUraian(String uraian) {
        this.uraian = uraian;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Penilaian> getPenilaianList() {
        return penilaianList;
    }

    public void setPenilaianList(List<Penilaian> penilaianList) {
        this.penilaianList = penilaianList;
    }
}
