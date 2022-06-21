package id.go.kemenkeu.siku.models.repositories;

import id.go.kemenkeu.siku.models.Indikator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IndikatorRepository extends JpaRepository<Indikator, Long> {
    @Query(value = "select * from indikator limit 10 ", nativeQuery = true)
    List<Indikator> findIndikator10Row();

    @Query(value = "select * from indikator limit 20 ",nativeQuery = true)
    List<Indikator> findIndikator20Row();

    @Query(value = "select count(id) from indikator ",nativeQuery = true)
    Long getCountIndikatorAll();


    @Query(value = "select * from indikator where uraian = ?1 ",nativeQuery = true)
    Indikator findIndikatorByUraian(String uraian);

    @Query(value = "select * from indikator " +
            "where uraian = ?1 and level=?2 order by uraian asc",nativeQuery = true)
    Indikator findIndikatorByUraianAndLevel(String uraian,int level);

    List<Indikator> findByLevel(int level);

    Optional<Indikator> findByLevelAndKode(int level, String kode);

    List<Indikator> findByLevelOrderById(int level);

    List<Indikator> findByKodeOrderById(String kode);

}
