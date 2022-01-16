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

        int wildCardPredictionsNeeded = 6;
        for(String result : correct.wildCardPredictions) {
            if(result.equals("EMPTY")) {
                wildCardPredictionsNeeded--;
            }
        }
        for(int i = 0; i < this.wildCardPredictions.size(); i++) {
            if(wildCardPredictionsNeeded == 0) {
                break;
            }
            if(this.getName().equals("Mohammad Khatami 1")) {
                System.out.println();
            }
            if (this.wildCardPredictions.contains(correct.wildCardPredictions.get(i))) {
                this.totalPoints += 10;
            } else {
                this.maxPoints -= 10;
                if(this.divisionalRoundPredictions.contains(correct.wildCardPredictions.get(i))) {
                    this.maxPoints -= 20;
                }
                if(this.conferenceTitlePredictions.contains(correct.wildCardPredictions.get(i))) {
                    this.maxPoints -= 40;
                }
                if(this.superbowlPredictions.contains(correct.wildCardPredictions.get(i))) {
                    this.maxPoints -= 80;
                }
            }
            wildCardPredictionsNeeded--;
        }

        int divisionalRoundPredictionsNeeded = 4;
        for(String result : correct.divisionalRoundPredictions) {
            if(result.equals("EMPTY")) {
                divisionalRoundPredictionsNeeded--;
            }
        }
        for(int i = 0; i < this.divisionalRoundPredictions.size(); i++) {
            if(divisionalRoundPredictionsNeeded == 0) {
                break;
            }
            if (this.divisionalRoundPredictions.contains(correct.divisionalRoundPredictions.get(i))) {
                this.totalPoints += 20;
            } else {
                this.maxPoints -= 20;
                if(this.conferenceTitlePredictions.contains(correct.divisionalRoundPredictions
                .get(i))) {
                    this.maxPoints -= 40;
                }
                if(this.superbowlPredictions.contains(correct.divisionalRoundPredictions.get(i)
                )) {
                    this.maxPoints -= 80;
                }
            }
            divisionalRoundPredictionsNeeded--;
        }

        int conferenceTitlePredictionsNeeded = 2;
        for(String result : correct.conferenceTitlePredictions) {
            if(result.equals("EMPTY")) {
                conferenceTitlePredictionsNeeded--;
            }
        }
        for(int i = 0; i < this.conferenceTitlePredictions.size(); i++) {
            if(conferenceTitlePredictionsNeeded == 0) {
                break;
            }
            if (this.conferenceTitlePredictions.contains(correct.conferenceTitlePredictions.get(i))) {
                this.totalPoints += 40;
            } else {
                this.maxPoints -= 40;
                if(this.superbowlPredictions.contains(correct.conferenceTitlePredictions.get(i))) {
                    this.maxPoints -= 80;
                }
            }
            conferenceTitlePredictionsNeeded--;
        }

        int superbowlPredictionsNeeded = 1;
        for(String result : correct.superbowlPredictions) {
            if(result.equals("EMPTY")) {
                superbowlPredictionsNeeded--;
            }
        }
        for(int i = 0; i < this.superbowlPredictions.size(); i++) {
            if(superbowlPredictionsNeeded == 0) {
                break;
            }
            if (this.superbowlPredictions.contains(correct.superbowlPredictions.get(i))) {
                this.totalPoints += 80;
            } else {
                this.maxPoints -= 80;
            }
            superbowlPredictionsNeeded--;
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
            return 1;
        } else if(this.getTotalPoints() < p.getTotalPoints()){
            return -1;
        }
        else {
            if(this.getMaxPoints() > p.getMaxPoints()) {
                return 1;
            } else if(this.getMaxPoints() < p.getMaxPoints()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
