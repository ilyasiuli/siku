package id.go.kemenkeu.siku.models;

import javax.persistence.*;

@Entity
@Table(name = "penilaian")
public class Penilaian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Indikator.class)
    @JoinColumn(name = "id_indikator")
    Indikator indikator;

    private String fileUpload; // /upload/filedukung1.pdf

    private int tahun;

}
