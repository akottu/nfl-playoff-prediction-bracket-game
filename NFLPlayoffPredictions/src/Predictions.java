import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Predictions {

    private String name;
    private List<String> wildCardPredictions;
    private List<String> divisionalRoundPredictions;
    private List<String> conferenceTitlePredictions;
    private List<String> superbowlPredictions;
    private int totalPoints;

    public Predictions() {

        super();
    }

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
                this.totalPoints += 1;
            }
        }

        for(int i = 0; i < this.divisionalRoundPredictions.size(); i++) {
            if (correct.divisionalRoundPredictions.contains(this.divisionalRoundPredictions.get(i))) {
                this.totalPoints += 2;
            }
        }

        for(int i = 0; i < this.conferenceTitlePredictions.size(); i++) {
            if (correct.conferenceTitlePredictions.contains(this.conferenceTitlePredictions.get(i))) {
                this.totalPoints += 4;
            }
        }

        for(int i = 0; i < this.superbowlPredictions.size(); i++) {
            if (correct.superbowlPredictions.contains(this.superbowlPredictions.get(i))) {
                this.totalPoints += 8;
            }
        }

    }


    public static void main(String [] args) {

        // results

        Predictions correct = new Predictions(
                "Correct",
                new ArrayList<String>(Arrays.asList("")),
                new ArrayList<String>(Arrays.asList("")),
                new ArrayList<String>(Arrays.asList("")),
                new ArrayList<String>(Arrays.asList("")),
                0
        );

        // participant predictions

        Predictions anish = new Predictions(
                "Anish",
                new ArrayList<String>(Arrays.asList("Patriots", "Bills", "Seahawks", "Saints")),
                new ArrayList<String>(Arrays.asList("Patriots", "Ravens", "Packers", "Niners")),
                new ArrayList<String>(Arrays.asList("Patriots", "Packers")),
                new ArrayList<String>(Arrays.asList("Packers")),
                0
        );

        Predictions girish = new Predictions(
                "Girish",
                new ArrayList<String>(Arrays.asList("Patriots", "Texans", "Seahawks", "Saints")),
                new ArrayList<String>(Arrays.asList("Ravens", "Chiefs", "Niners", "Saints")),
                new ArrayList<String>(Arrays.asList("Chiefs", "Niners")),
                new ArrayList<String>(Arrays.asList("Niners")),
                0
        );

        Predictions adit = new Predictions(
                "Adit",
                new ArrayList<String>(Arrays.asList("Patriots", "Bills", "Eagles", "Saints")),
                new ArrayList<String>(Arrays.asList("Ravens", "Chiefs", "Niners", "Packers")),
                new ArrayList<String>(Arrays.asList("Chiefs", "Niners")),
                new ArrayList<String>(Arrays.asList("Chiefs")),
                0
        );

        Predictions brian = new Predictions(
                "Brian",
                new ArrayList<String>(Arrays.asList("Patriots", "Bills", "Seahawks", "Saints")),
                new ArrayList<String>(Arrays.asList("Niners", "Saints", "Ravens", "Patriots")),
                new ArrayList<String>(Arrays.asList("Ravens", "Niners")),
                new ArrayList<String>(Arrays.asList("Ravens")),
                0
        );

        Predictions ashwin = new Predictions(
                "Ashwin",
                new ArrayList<String>(Arrays.asList("Patriots", "Texans", "Eagles", "Saints")),
                new ArrayList<String>(Arrays.asList("Ravens", "Patriots", "Niners", "Saints")),
                new ArrayList<String>(Arrays.asList("Patriots", "Niners")),
                new ArrayList<String>(Arrays.asList("Patriots")),
                0
        );

        Predictions akash = new Predictions(
                "Akash",
                new ArrayList<String>(Arrays.asList("Patriots", "Bills", "Eagles", "Saints")),
                new ArrayList<String>(Arrays.asList("Ravens", "Chiefs", "Niners", "Saints")),
                new ArrayList<String>(Arrays.asList("Chiefs", "Niners")),
                new ArrayList<String>(Arrays.asList("Niners")),
                0
        );




        // update player points

        anish.updatePoints(correct);
        girish.updatePoints(correct);
        adit.updatePoints(correct);
        akash.updatePoints(correct);
        brian.updatePoints(correct);
        ashwin.updatePoints(correct);







        // display all point totals

        System.out.println(anish.name + ": " + anish.totalPoints);
        System.out.println(girish.name + ": " + girish.totalPoints);
        System.out.println(adit.name + ": " + adit.totalPoints);
        System.out.println(akash.name + ": " + akash.totalPoints);
        System.out.println(brian.name + ": " + brian.totalPoints);
        System.out.println(ashwin.name + ": " + ashwin.totalPoints);






    }

}
