package fr.orsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.orsys.entity.Compte;

@RepositoryRestResource(collectionResourceRel = "comptes", path = "comptes")
public interface CompteRepository extends JpaRepository<Compte, Integer> {
}
