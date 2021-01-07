import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

  public static final String RAVENS = "Ravens";
  public static final String STEELERS = "Steelers";
  public static final String BILLS = "Bills";
  public static final String BUCCANEERS = "Buccaneers";
  public static final String RAMS = "Rams";
  public static final String SAINTS = "Saints";
  public static final String CHIEFS = "Chiefs";
  public static final String PACKERS = "Packers";
  public static final String SEAHAWKS = "Seahawks";
  public static final String BROWNS = "Browns";

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

    List<Predictions> rgPredictionsList = new ArrayList();
    List<Predictions> shotPredictionsList = new ArrayList();

    // participant predictions

    Predictions ram = new Predictions(
        "Ram",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, BUCCANEERS, RAMS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, BUCCANEERS)),
        new ArrayList<String>(Arrays.asList(BILLS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );
    shotPredictionsList.add(ram);

    Predictions jay = new Predictions(
        "Jay",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, BUCCANEERS, RAMS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, BUCCANEERS)),
        new ArrayList<String>(Arrays.asList(BILLS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );
    shotPredictionsList.add(jay);

    Predictions alex = new Predictions(
        "Alex",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, BUCCANEERS, RAMS, SAINTS)),
        new ArrayList<String>(Arrays.asList(RAVENS, BILLS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(BILLS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );
    shotPredictionsList.add(alex);

    Predictions alan = new Predictions(
        "Alan",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );
    shotPredictionsList.add(alan);

    Predictions anishshot = new Predictions(
        "Anish",
        new ArrayList<String>(
            Arrays.asList(RAVENS, BROWNS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(BILLS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );
    shotPredictionsList.add(anishshot);

    Predictions anishrg = new Predictions(
        "Anish",
        new ArrayList<String>(
            Arrays.asList(RAVENS, BROWNS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );
    rgPredictionsList.add(anishrg);

    Predictions girish = new Predictions(
        "Girish",
        new ArrayList<String>(
            Arrays.asList(BROWNS, BILLS, RAVENS, RAMS, SAINTS, BUCCANEERS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, RAVENS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, PACKERS)),
        new ArrayList<String>(Arrays.asList(CHIEFS)),
        0
    );
    rgPredictionsList.add(girish);

    Predictions akash = new Predictions(
        "Akash",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, RAMS, BUCCANEERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS)),
        0
    );
    rgPredictionsList.add(akash);

    Predictions brian = new Predictions(
        "Brian",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(RAVENS, STEELERS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(RAVENS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );
    rgPredictionsList.add(brian);

    Predictions sujay = new Predictions(
        "Sujay",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, STEELERS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );
    rgPredictionsList.add(sujay);

    // update player points

    ram.updatePoints(correct);
    alex.updatePoints(correct);
    alan.updatePoints(correct);
    jay.updatePoints(correct);
    anishshot.updatePoints(correct);

    anishrg.updatePoints(correct);
    girish.updatePoints(correct);
    akash.updatePoints(correct);
    brian.updatePoints(correct);
    brian.updatePoints(correct);

    Collections.shuffle(rgPredictionsList);
    Collections.shuffle(shotPredictionsList);

    Collections.sort(rgPredictionsList, Collections.reverseOrder());
    Collections.sort(shotPredictionsList, Collections.reverseOrder());

    // display all point totals

    System.out.println();

    System.out.format("%22s\n", "RG STANDINGS");
    System.out.println();
    for(int i = 0; i < rgPredictionsList.size(); i++) {
      Predictions p = rgPredictionsList.get(i);
      System.out.format("%2d%15s%5d\n", i + 1, p.getName(), p.getTotalPoints());
    }

    System.out.println();
    System.out.println();

    System.out.format("%22s\n", "THE SHOT STANDINGS");
    System.out.println();
    for(int i = 0; i < shotPredictionsList.size(); i++) {
      Predictions p = shotPredictionsList.get(i);
      System.out.format("%2d%15s%5d\n", i + 1, p.getName(), p.getTotalPoints());
    }
  }

}
