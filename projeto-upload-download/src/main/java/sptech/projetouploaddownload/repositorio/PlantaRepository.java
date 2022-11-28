package sptech.projetouploaddownload.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import sptech.projetouploaddownload.dominio.Planta;

public interface PlantaRepository extends JpaRepository<Planta, Integer> {

    @Modifying
    @Transactional
    @Query("update Planta p set p.foto = ?2 where p.id = ?1")
    void setFoto(Integer id, byte[] foto);

    @Query("select p.foto from Planta p where p.id = ?1")
    byte[] getFoto(Integer id);

    @Modifying
    @Transactional
    @Query("update Planta p set p.relatorioExcel = ?2 where p.id = ?1")
    void setRelatorio(Integer id, byte[] foto);

    @Query("select p.relatorioExcel from Planta p where p.id = ?1")
    byte[] getRelatorio(Integer id);
}
