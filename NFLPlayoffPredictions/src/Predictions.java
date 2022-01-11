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
    private int maxPoints;

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
        this.maxPoints =
            wildCardPredictions.size() * 10
                + divisionalRoundPredictions.size() * 20
                + conferenceTitlePredictions.size() * 40
                + superbowlPredictions.size() * 80;
    }

    public void updatePoints(Predictions correct) {

        for(int i = 0; i < this.wildCardPredictions.size(); i++) {
            if (correct.wildCardPredictions.contains(this.wildCardPredictions.get(i))) {
                this.totalPoints += 10;
            } else {
//                this.maxPoints -= 10;
                if(this.divisionalRoundPredictions.contains(this.wildCardPredictions.get(i))) {
//                    this.maxPoints -= 20;
                }
                if(this.conferenceTitlePredictions.contains(this.wildCardPredictions.get(i))) {
//                    this.maxPoints -= 40;
                }
                if(this.superbowlPredictions.contains(this.wildCardPredictions.get(i))) {
//                    this.maxPoints -= 80;
                }
            }
        }

        for(int i = 0; i < this.divisionalRoundPredictions.size(); i++) {
            if (correct.divisionalRoundPredictions.contains(this.divisionalRoundPredictions.get(i))) {
                this.totalPoints += 20;
            } else {
//                this.maxPoints -= 20;
//                if(this.conferenceTitlePredictions.contains(this.divisionalRoundPredictions.get(i))) {
//                    this.maxPoints -= 40;
//                }
//                if(this.superbowlPredictions.contains(this.divisionalRoundPredictions.get(i))) {
//                    this.maxPoints -= 80;
//                }
            }
        }

        for(int i = 0; i < this.conferenceTitlePredictions.size(); i++) {
            if (correct.conferenceTitlePredictions.contains(this.conferenceTitlePredictions.get(i))) {
                this.totalPoints += 40;
            } else {
//                this.maxPoints -= 40;
//                if(this.superbowlPredictions.contains(this.conferenceTitlePredictions.get(i))) {
//                    this.maxPoints -= 80;
//                }
            }
        }

        for(int i = 0; i < this.superbowlPredictions.size(); i++) {
            if (correct.superbowlPredictions.contains(this.superbowlPredictions.get(i))) {
                this.totalPoints += 80;
            } else {
//                this.maxPoints -= 80;
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

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    @Override
    public int compareTo(Object o) {
        Predictions p = (Predictions)o;
        int result = 0;
        if(this.getTotalPoints() > p.getTotalPoints()) {
            result++;
            if(this.getMaxPoints() > p.getMaxPoints()) {
                result++;
            }
        } else if(this.getTotalPoints() < p.getTotalPoints()){
            result--;
            if(this.getMaxPoints() < p.getMaxPoints()) {
                result--;
            }
        }
        return result;
    }
}
