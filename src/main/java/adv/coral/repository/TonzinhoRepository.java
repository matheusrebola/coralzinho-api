package adv.coral.repository;

import adv.coral.model.Tonzinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TonzinhoRepository extends JpaRepository<Tonzinho, Long> {
}
