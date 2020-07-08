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
public class BuzzWord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer buzzWordId;

    private String buzzWordString;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "themeId", referencedColumnName = "themeId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Theme theme;

    @OneToMany( cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "buzzword")
    private List<CardEntry> cardEntries;

    public Integer getBuzzWordId() {
        return buzzWordId;
    }

    public void setBuzzWordId(Integer buzzWordId) {
        this.buzzWordId = buzzWordId;
    }

    public String getBuzzWordString() {
        return buzzWordString;
    }

    public void setBuzzWordString(String buzzWord) {
        this.buzzWordString = buzzWord;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public List<CardEntry> getCardEntries() {
        return cardEntries;
    }

    public void setCardEntries(List<CardEntry> cardEntries) {
        this.cardEntries = cardEntries;
    }
}
