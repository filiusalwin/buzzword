package nl.miwgroningen.cohort3.alwin.buzzword.demo.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alwin Filius
 * Dit is een uitwerking van opdracht:
 * <p>
 * Beschrijving programma
 */
@Entity
public class CardEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cardEntryId;

    private Double xCoordinate;

    private Double yCoordinate;

    private Boolean checkedBingo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "buzzwordId", referencedColumnName = "buzzwordId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private BuzzWord buzzword;

    @OneToMany( cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "cardEntry")
    private List<BingoCard> bingoCards;

    public Integer getCardEntryId() {
        return cardEntryId;
    }

    public void setCardEntryId(Integer cardEntryId) {
        this.cardEntryId = cardEntryId;
    }

    public Double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(Double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(Double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Boolean getCheckedBingo() {
        return checkedBingo;
    }

    public void setCheckedBingo(Boolean checkedBingo) {
        this.checkedBingo = checkedBingo;
    }

    public BuzzWord getBuzzword() {
        return buzzword;
    }

    public void setBuzzword(BuzzWord buzzword) {
        this.buzzword = buzzword;
    }

    public List<BingoCard> getBingoCards() {
        return bingoCards;
    }

    public void setBingoCards(List<BingoCard> bingoCards) {
        this.bingoCards = bingoCards;
    }
}
