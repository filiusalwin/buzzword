package nl.miwgroningen.cohort3.alwin.buzzword.demo.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

/**
 * @author Alwin Filius
 * Dit is een uitwerking van opdracht:
 * <p>
 * Beschrijving programma
 */
@Entity
public class BingoCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bingoCardId;

    private Integer sizeCard;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cardEntryId", referencedColumnName = "cardEntryId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CardEntry cardEntry;

}
