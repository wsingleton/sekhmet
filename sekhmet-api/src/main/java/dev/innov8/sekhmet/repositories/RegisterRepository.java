package dev.innov8.sekhmet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.innov8.sekhmet.models.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {

	List<Register> findByType(String type);
	
}
