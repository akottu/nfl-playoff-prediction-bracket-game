import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Predictions implements Comparable {

    private String name;
    private List<String> wildCardPredictions;
    private List<String> divisionalRoundPredictions;
    private List<String> conferenceTitlePredictions;
    private List<String> superbowlPredictions;
    private int totalPoints;

    public Predictions(String name,
                       List<String> wildCardPredictions,
                       List<String> divisionalRoundPredictions,
                       List<String> conferenceTitlePredictions,
                       List<String> superbowlPredictions,
                       int totalPoints)
    {
        this.name = name;
        this.wildCardPredictions = wildCardPredictions;
        this.conferenceTitlePredictions = conferenceTitlePredictions;
        this.divisionalRoundPredictions = divisionalRoundPredictions;
        this.superbowlPredictions = superbowlPredictions;
        this.totalPoints = totalPoints;
    }

    public void updatePoints(Predictions correct) {

        for(int i = 0; i < this.wildCardPredictions.size(); i++) {
            if (correct.wildCardPredictions.contains(this.wildCardPredictions.get(i))) {
                this.totalPoints += 10;
            }
        }

        for(int i = 0; i < this.divisionalRoundPredictions.size(); i++) {
            if (correct.divisionalRoundPredictions.contains(this.divisionalRoundPredictions.get(i))) {
                this.totalPoints += 20;
            }
        }

        for(int i = 0; i < this.conferenceTitlePredictions.size(); i++) {
            if (correct.conferenceTitlePredictions.contains(this.conferenceTitlePredictions.get(i))) {
                this.totalPoints += 40;
            }
        }

        for(int i = 0; i < this.superbowlPredictions.size(); i++) {
            if (correct.superbowlPredictions.contains(this.superbowlPredictions.get(i))) {
                this.totalPoints += 80;
            }
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getWildCardPredictions() {
        return wildCardPredictions;
    }

    public void setWildCardPredictions(List<String> wildCardPredictions) {
        this.wildCardPredictions = wildCardPredictions;
    }

    public List<String> getDivisionalRoundPredictions() {
        return divisionalRoundPredictions;
    }

    public void setDivisionalRoundPredictions(List<String> divisionalRoundPredictions) {
        this.divisionalRoundPredictions = divisionalRoundPredictions;
    }

    public List<String> getConferenceTitlePredictions() {
        return conferenceTitlePredictions;
    }

    public void setConferenceTitlePredictions(List<String> conferenceTitlePredictions) {
        this.conferenceTitlePredictions = conferenceTitlePredictions;
    }

    public List<String> getSuperbowlPredictions() {
        return superbowlPredictions;
    }

    public void setSuperbowlPredictions(List<String> superbowlPredictions) {
        this.superbowlPredictions = superbowlPredictions;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    @Override
    public int compareTo(Object o) {
        Predictions p = (Predictions)o;
        if(this.getTotalPoints() > p.getTotalPoints()) return 1;
        else return -1;
    }
}
