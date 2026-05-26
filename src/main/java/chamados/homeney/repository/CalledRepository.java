package chamados.homeney.repository;
import chamados.homeney.entity.Called;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalledRepository extends JpaRepository<Called, Long> {

}
