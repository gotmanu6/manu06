package repositories;

import models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}