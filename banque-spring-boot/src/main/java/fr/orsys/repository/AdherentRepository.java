package fr.orsys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import fr.orsys.entity.Adherent;

@Transactional
@RepositoryRestResource(collectionResourceRel = "adherents", path = "adherents")
public interface AdherentRepository extends JpaRepository<Adherent, Integer> {
	 List<Adherent> findByPrenom(@Param("prenom") String prenom);
	 List<Adherent> getByEmail(String email);
	 Long deleteByPrenom(String lastname);
	 Long countByNomAndPrenom(String nom, String prenom);
	 List<Adherent> removeByEmail(String email);
}
