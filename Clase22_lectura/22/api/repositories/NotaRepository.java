
package ar.com.portfoliobracciale.api.repositories;

import ar.com.portfoliobracciale.api.models.Nota;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository<Nota,Long> {
    
    public List<Nota> findAllByPersonId(Long personId);
    
    @Query (value="SELECT * FROM nota n WHERE n.calificacion >6", nativeQuery = true)
    public ArrayList<Nota> findAllAprobedNotes();
   
    @Query(value="SELECT AVG(calificacion) FROM nota n INNER JOIN person p ON n.person_id = :id", 
    nativeQuery = true)
    public double findAvgPorPersona(@Param ("id") Long id);
       
}
