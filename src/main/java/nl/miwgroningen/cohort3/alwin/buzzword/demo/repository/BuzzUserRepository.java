package nl.miwgroningen.cohort3.alwin.buzzword.demo.repository;

import nl.miwgroningen.cohort3.alwin.buzzword.demo.model.BuzzUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Alwin Filius
 * Dit is een uitwerking van opdracht:
 * <p>
 * Beschrijving programma
 */
public interface BuzzUserRepository extends JpaRepository<BuzzUser, Integer> {
    Optional<BuzzUser> findByUsername(String username);
}
