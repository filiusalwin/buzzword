package nl.miwgroningen.cohort3.alwin.buzzword.demo.repository;

import nl.miwgroningen.cohort3.alwin.buzzword.demo.model.BuzzWord;
import nl.miwgroningen.cohort3.alwin.buzzword.demo.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Alwin Filius
 * Dit is een uitwerking van opdracht:
 * <p>
 * Beschrijving programma
 */
public interface BuzzWordRepository extends JpaRepository<BuzzWord, Integer> {
    List<BuzzWord> findByTheme(Theme theme);


}
