import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

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
  public static final String TITANS = "Titans";
  public static final String WASHINGTON = "Washington";
  private static final String BENGALS = "Bengals";
  private static final String COWBOYS = "Cowboys";
  public static final String BEARS = "Bears";
  public static final String COLTS = "Colts";
  public static final String EMPTY = "Empty";
  public static final String WILD_CARD = "Wild Card";
  public static final String DIVISIONAL = "Divisional";
  public static final String CONFERENCE = "Conference";
  public static final String SUPER_BOWL = "Super Bowl";

  public static void main(String [] args) {

    /**
     * 2021 PLAYOFFS
     */

    // results

//    results2021();

    /**
     * 2022 PLAYOFFS
     */



    Predictions chalk = new Predictions(
        "CHALK",
        new ArrayList<>(
            Arrays.asList(BENGALS, BILLS, BUCCANEERS, COWBOYS, CHIEFS, RAMS)),
        new ArrayList<>(Arrays.asList(TITANS, CHIEFS, PACKERS, BUCCANEERS)),
        new ArrayList<>(Arrays.asList(TITANS, PACKERS)),
        new ArrayList<>(Arrays.asList(PACKERS)),
        0
    );

    Predictions correct = new Predictions(
        "CORRECT",
        new ArrayList<>(
            Arrays.asList(EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY)),
        new ArrayList<>(Arrays.asList(EMPTY, EMPTY, EMPTY, EMPTY)),
        new ArrayList<>(Arrays.asList(EMPTY, EMPTY)),
        new ArrayList<>(Arrays.asList(EMPTY)),
        0
    );

    List<Predictions> roland_glen_predictions = new ArrayList();
    List<Predictions> hitch_route_panel_predictions = new ArrayList();
    List<Predictions> hitch_route_pool_predictions = new ArrayList();

    // participant predictions

    Predictions anish_kottu_1 = new Predictions(
        "Anish Kottu 1",
        new ArrayList<>(
            Arrays.asList(BENGALS, BILLS, BUCCANEERS, COWBOYS, CHIEFS, RAMS)),
        new ArrayList<>(Arrays.asList(TITANS, CHIEFS, PACKERS, BUCCANEERS)),
        new ArrayList<>(Arrays.asList(TITANS, PACKERS)),
        new ArrayList<>(Arrays.asList(PACKERS)),
        0
    );

    roland_glen_predictions.add(anish_kottu_1);

    hitch_route_panel_predictions.add(anish_kottu_1);

    hitch_route_pool_predictions.add(anish_kottu_1);


    String[] rounds = {WILD_CARD, DIVISIONAL, CONFERENCE, SUPER_BOWL};

    HashMap<String, TreeMap<String, Integer>> roland_glen_prediction_map = new HashMap<>();
    initializePredictionMap(roland_glen_prediction_map);
    populatePredictionMap(roland_glen_predictions, rounds, roland_glen_prediction_map);
    System.out.println();
    System.out.format("%60s\n", "RG WINNER FREQUENCIES");
    System.out.println();
    displayWinnerPickFrequencies(roland_glen_prediction_map);

    roland_glen_predictions.add(chalk);
    hitch_route_panel_predictions.add(chalk);
    hitch_route_pool_predictions.add(chalk);

    updatePoints(
        correct,
        roland_glen_predictions,
        hitch_route_panel_predictions,
        hitch_route_pool_predictions);

    Collections.shuffle(roland_glen_predictions);

    Collections.sort(roland_glen_predictions, Collections.reverseOrder());

    // display all point totals

    System.out.println();

    System.out.format("%39s\n", "RG STANDINGS");
    System.out.println();
    for(int i = 0; i < roland_glen_predictions.size(); i++) {
      Predictions p = roland_glen_predictions.get(i);
      System.out.format("%3d%25s%5d%2s%4d\n", i + 1, p.getName(), p.getTotalPoints(), "/",
          p.getMaxPoints());
    }

    System.out.println();
    System.out.println();
  }

  private static void results2021() {
    Predictions correct = new Predictions(
        "Chalk",
        new ArrayList<>(
            Arrays.asList(BILLS, STEELERS, TITANS, SAINTS, SEAHAWKS, WASHINGTON)),
        new ArrayList<>(Arrays.asList(CHIEFS, BILLS, PACKERS, SAINTS)),
        new ArrayList<>(Arrays.asList(CHIEFS, PACKERS)),
        new ArrayList<>(Arrays.asList(CHIEFS)),
        0
    );

//    Predictions correct = new Predictions(
//        "Correct",
//        new ArrayList<>(
//            Arrays.asList(BILLS, RAMS, BUCCANEERS, RAVENS, SAINTS, BROWNS)),
//        new ArrayList<>(Arrays.asList(EMPTY, EMPTY, EMPTY, EMPTY)),
//        new ArrayList<>(Arrays.asList(EMPTY, EMPTY)),
//        new ArrayList<>(Arrays.asList(EMPTY)),
//        0
//    );

    List<Predictions> rgPredictionsList = new ArrayList();
    List<Predictions> shotPredictionsList = new ArrayList();
    List<Predictions> bettingPool = new ArrayList();

    // participant predictions

    Predictions ram_gollapudy = new Predictions(
        "Ram G",
        new ArrayList<>(
            Arrays.asList(TITANS, STEELERS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<>(Arrays.asList(CHIEFS, BILLS, PACKERS, SAINTS)),
        new ArrayList<>(Arrays.asList(PACKERS, BILLS)),
        new ArrayList<>(Arrays.asList(PACKERS)),
        0
    );

    Predictions jay = new Predictions(
        "Jay",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, BUCCANEERS, RAMS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, BUCCANEERS)),
        new ArrayList<String>(Arrays.asList(BILLS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );

    Predictions alex_f = new Predictions(
        "Alex F",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, BUCCANEERS, RAMS, SAINTS)),
        new ArrayList<String>(Arrays.asList(RAVENS, BILLS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(BILLS, PACKERS)),
        new ArrayList<String>(Arrays.asList(BILLS)),
        0
    );

    Predictions alan = new Predictions(
        "Alan",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );

    Predictions anishshot = new Predictions(
        "Anish",
        new ArrayList<String>(
            Arrays.asList(RAVENS, BROWNS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(BILLS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );

    Predictions anishrg = new Predictions(
        "Anish",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, PACKERS)),
        new ArrayList<String>(Arrays.asList(CHIEFS)),
        0
    );

    Predictions girish = new Predictions(
        "Girish",
        new ArrayList<String>(
            Arrays.asList(BROWNS, BILLS, RAVENS, RAMS, SAINTS, BUCCANEERS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, RAVENS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, PACKERS)),
        new ArrayList<String>(Arrays.asList(CHIEFS)),
        0
    );

    Predictions ruda = new Predictions(
        "Ruda",
        new ArrayList<String>(
            Arrays.asList(TITANS, STEELERS, BILLS, SEAHAWKS, BUCCANEERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, SEAHAWKS)),
        new ArrayList<String>(Arrays.asList(PACKERS, BILLS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );

    Predictions akash = new Predictions(
        "Akash",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, RAMS, BUCCANEERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS)),
        0
    );

    Predictions brian = new Predictions(
        "Brian",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(RAVENS, STEELERS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(RAVENS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );

    Predictions adit = new Predictions(
        "Adit",
        new ArrayList<String>(
            Arrays.asList(TITANS, STEELERS, BILLS, BUCCANEERS, RAMS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, BUCCANEERS, PACKERS)),
        new ArrayList<String>(Arrays.asList(BUCCANEERS, CHIEFS)),
        new ArrayList<String>(Arrays.asList(BUCCANEERS)),
        0
    );

    Predictions sujay = new Predictions(
        "Sujay",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, STEELERS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );

    Predictions ashwin = new Predictions(
        "Ashwin",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, BUCCANEERS, RAMS, SAINTS)),
        new ArrayList<String>(Arrays.asList(RAVENS, BILLS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(BILLS, SAINTS)),
        new ArrayList<String>(Arrays.asList(SAINTS)),
        0
    );

    Predictions arjun = new Predictions(
        "Arjun",
        new ArrayList<String>(
            Arrays.asList(TITANS, STEELERS, BILLS, WASHINGTON, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, STEELERS, PACKERS, SEAHAWKS)),
        new ArrayList<String>(Arrays.asList(STEELERS, PACKERS)),
        new ArrayList<String>(Arrays.asList(STEELERS)),
        0
    );

    Predictions john = new Predictions(
        "John",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, BUCCANEERS, RAMS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, STEELERS, BUCCANEERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS)),
        0
    );

    Predictions sam = new Predictions(
        "Sam",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(BILLS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );

    Predictions hunter = new Predictions(
        "Hunter",
        new ArrayList<String>(
            Arrays.asList(RAVENS, BROWNS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );

    Predictions will_schmitt = new Predictions(
        "Will S",
        new ArrayList<String>(
            Arrays.asList(RAVENS, BROWNS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, BUCCANEERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BUCCANEERS)),
        new ArrayList<String>(Arrays.asList(BUCCANEERS)),
        0
    );

    Predictions ethan = new Predictions(
        "Ethan",
        new ArrayList<String>(
            Arrays.asList(TITANS, STEELERS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, SEAHAWKS, PACKERS)),
        new ArrayList<String>(Arrays.asList(BILLS, PACKERS)),
        new ArrayList<String>(Arrays.asList(BILLS)),
        0
    );

    Predictions brenden = new Predictions(
        "Brenden",
        new ArrayList<String>(
            Arrays.asList(BROWNS, TITANS, BILLS, SEAHAWKS, BUCCANEERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(BILLS, PACKERS)),
        new ArrayList<String>(Arrays.asList(BILLS)),
        0
    );

    Predictions rob = new Predictions(
        "Rob",
        new ArrayList<String>(
            Arrays.asList(BILLS, STEELERS, RAVENS, RAMS, BUCCANEERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(SAINTS, PACKERS, BILLS, CHIEFS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );

    Predictions bhavin = new Predictions(
        "Bhavin",
        new ArrayList<String>(
            Arrays.asList(TITANS, STEELERS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, STEELERS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, SAINTS)),
        new ArrayList<String>(Arrays.asList(SAINTS)),
        0
    );

    Predictions sanjay = new Predictions(
        "Sanjay",
        new ArrayList<String>(
            Arrays.asList(TITANS, STEELERS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, BUCCANEERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BUCCANEERS)),
        new ArrayList<String>(Arrays.asList(CHIEFS)),
        0
    );

    Predictions will_furth = new Predictions(
        "Will F",
        new ArrayList<String>(
            Arrays.asList(BROWNS, TITANS, BILLS, WASHINGTON, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, TITANS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );

    Predictions sid = new Predictions(
        "Sid",
        new ArrayList<String>(
            Arrays.asList(BROWNS, RAVENS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(BILLS, PACKERS)),
        new ArrayList<String>(Arrays.asList(BILLS)),
        0
    );

    Predictions vishal = new Predictions(
        "Vishal",
        new ArrayList<String>(
            Arrays.asList(BROWNS, TITANS, BILLS, RAMS, BUCCANEERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, SAINTS)),
        new ArrayList<String>(Arrays.asList(SAINTS)),
        0
    );

    Predictions ram_bala = new Predictions(
        "Ram B",
        new ArrayList<String>(
            Arrays.asList(BROWNS, TITANS, BILLS, WASHINGTON, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(BILLS, CHIEFS)),
        new ArrayList<String>(Arrays.asList(BILLS)),
        0
    );

    Predictions peter = new Predictions(
        "Peter",
        new ArrayList<String>(
            Arrays.asList(TITANS, STEELERS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, BUCCANEERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS)),
        0
    );

    Predictions fernando = new Predictions(
        "Fernando",
        new ArrayList<String>(
            Arrays.asList(BROWNS, TITANS, BILLS, RAMS, BUCCANEERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );

    Predictions christian = new Predictions(
        "Christian",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, BUCCANEERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BUCCANEERS)),
        new ArrayList<String>(Arrays.asList(CHIEFS)),
        0
    );

    Predictions brooks = new Predictions(
        "Brooks",
        new ArrayList<String>(
            Arrays.asList(TITANS, STEELERS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, STEELERS, PACKERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, PACKERS)),
        new ArrayList<String>(Arrays.asList(CHIEFS)),
        0
    );

    Predictions mattan = new Predictions(
        "Mattan",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, WASHINGTON, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, SEAHAWKS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );

    Predictions allan = new Predictions(
        "Allan",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, BILLS, PACKERS, SEAHAWKS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );

    Predictions shanrick = new Predictions(
        "Shanrick",
        new ArrayList<String>(
            Arrays.asList(BUCCANEERS, SEAHAWKS, SAINTS, BILLS, STEELERS, RAVENS)),
        new ArrayList<String>(Arrays.asList(BUCCANEERS, SEAHAWKS, BILLS, RAVENS)),
        new ArrayList<String>(Arrays.asList(BILLS, SEAHAWKS)),
        new ArrayList<String>(Arrays.asList(BILLS)),
        0
    );

    Predictions wes = new Predictions(
        "Wes",
        new ArrayList<String>(
            Arrays.asList(BILLS, BUCCANEERS, SEAHAWKS, BEARS, TITANS, STEELERS)),
        new ArrayList<String>(Arrays.asList(PACKERS, CHIEFS, BILLS, SEAHAWKS)),
        new ArrayList<String>(Arrays.asList(BILLS, PACKERS)),
        new ArrayList<String>(Arrays.asList(PACKERS)),
        0
    );

    Predictions eddy = new Predictions(
        "Eddy",
        new ArrayList<String>(
            Arrays.asList(RAVENS, STEELERS, BILLS, WASHINGTON, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(PACKERS, CHIEFS, STEELERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS)),
        0
    );

    Predictions mihir = new Predictions(
        "Mihir",
        new ArrayList<String>(
            Arrays.asList(COLTS, RAVENS, BROWNS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(PACKERS, CHIEFS, RAVENS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, PACKERS)),
        new ArrayList<String>(Arrays.asList(CHIEFS)),
        0
    );

    Predictions gaurav = new Predictions(
        "Gaurav",
        new ArrayList<String>(
            Arrays.asList(BILLS, RAVENS, STEELERS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(BUCCANEERS, SEAHAWKS, CHIEFS, BILLS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, SEAHAWKS)),
        new ArrayList<String>(Arrays.asList(CHIEFS)),
        0
    );

    Predictions alex_b = new Predictions(
        "Alex B",
        new ArrayList<String>(
            Arrays.asList(BILLS, STEELERS, RAVENS, BUCCANEERS, SEAHAWKS, SAINTS)),
        new ArrayList<String>(Arrays.asList(PACKERS, CHIEFS, STEELERS, SAINTS)),
        new ArrayList<String>(Arrays.asList(CHIEFS, PACKERS)),
        new ArrayList<String>(Arrays.asList(CHIEFS)),
        0
    );

    rgPredictionsList.add(ashwin);
    rgPredictionsList.add(brian);
    rgPredictionsList.add(akash);
    rgPredictionsList.add(sujay);
    rgPredictionsList.add(girish);
    rgPredictionsList.add(ruda);
    rgPredictionsList.add(adit);
    rgPredictionsList.add(anishrg);
    rgPredictionsList.add(will_furth);
    rgPredictionsList.add(sid);
    rgPredictionsList.add(arjun);

    shotPredictionsList.add(anishshot);
    shotPredictionsList.add(alan);
    shotPredictionsList.add(alex_f);
    shotPredictionsList.add(jay);
    shotPredictionsList.add(ram_gollapudy);

    bettingPool.add(wes);
    bettingPool.add(will_schmitt);
    bettingPool.add(eddy);
    bettingPool.add(hunter);
    bettingPool.add(sam);
    bettingPool.add(john);
    bettingPool.add(ashwin);
    bettingPool.add(sujay);
    bettingPool.add(akash);
    bettingPool.add(anishrg);
    bettingPool.add(jay);
    bettingPool.add(alex_f);
    bettingPool.add(ethan);
    bettingPool.add(mihir);
    bettingPool.add(girish);
    bettingPool.add(rob);
    bettingPool.add(brenden);
    bettingPool.add(bhavin);
    bettingPool.add(sanjay);
    bettingPool.add(will_furth);
    bettingPool.add(sid);
    bettingPool.add(vishal);
    bettingPool.add(ram_bala);
    bettingPool.add(fernando);
    bettingPool.add(allan);
    bettingPool.add(peter);
    bettingPool.add(brooks);
    bettingPool.add(mattan);
    bettingPool.add(christian);
    bettingPool.add(shanrick);
    bettingPool.add(alex_b);
    bettingPool.add(gaurav);

    String[] rounds = {WILD_CARD, DIVISIONAL, CONFERENCE, SUPER_BOWL};

    HashMap<String, TreeMap<String, Integer>> rgPredictionMap = new HashMap<>();
    initializePredictionMap(rgPredictionMap);
    populatePredictionMap(rgPredictionsList, rounds, rgPredictionMap);
    System.out.println();
    System.out.format("%60s\n", "RG WINNER FREQUENCIES");
    System.out.println();
    displayWinnerPickFrequencies(rgPredictionMap);

    HashMap<String, TreeMap<String, Integer>> shotPredictionMap = new HashMap<>();
    initializePredictionMap(shotPredictionMap);
    populatePredictionMap(shotPredictionsList, rounds, shotPredictionMap);
    System.out.println();
    System.out.format("%60s\n", "THE SHOT WINNER FREQUENCIES");
    System.out.println();
    displayWinnerPickFrequencies(shotPredictionMap);

    HashMap<String, TreeMap<String, Integer>> bettingPoolPredictionMap = new HashMap<>();
    initializePredictionMap(bettingPoolPredictionMap);
    populatePredictionMap(bettingPool, rounds, bettingPoolPredictionMap);
    System.out.println();
    System.out.format("%60s\n", "BETTING POOL WINNER FREQUENCIES");
    System.out.println();
    displayWinnerPickFrequencies(bettingPoolPredictionMap);

    // update player points

    updatePoints(correct, rgPredictionsList, shotPredictionsList, bettingPool);

    Collections.shuffle(rgPredictionsList);
    Collections.shuffle(shotPredictionsList);
    Collections.shuffle(bettingPool);

    Collections.sort(rgPredictionsList, Collections.reverseOrder());
    Collections.sort(shotPredictionsList, Collections.reverseOrder());
    Collections.sort(bettingPool, Collections.reverseOrder());

    // display all point totals

    System.out.println();

    System.out.format("%28s\n", "RG STANDINGS");
    System.out.println();
    for(int i = 0; i < rgPredictionsList.size(); i++) {
      Predictions p = rgPredictionsList.get(i);
      System.out.format("%2d%15s%5d%2s%4d\n", i + 1, p.getName(), p.getTotalPoints(), "/",
          p.getMaxPoints());
    }

    System.out.println();
    System.out.println();

    System.out.format("%28s\n", "THE SHOT STANDINGS");
    System.out.println();
    for(int i = 0; i < shotPredictionsList.size(); i++) {
      Predictions p = shotPredictionsList.get(i);
      System.out.format("%2d%15s%5d%2s%4d\n", i + 1, p.getName(), p.getTotalPoints(), "/",
          p.getMaxPoints());
    }

    System.out.println();
    System.out.println();

    System.out.format("%28s\n", "BETTING POOL STANDINGS");
    System.out.println();
    for(int i = 0; i < bettingPool.size(); i++) {
      Predictions p = bettingPool.get(i);
      System.out.format("%2d%15s%5d%2s%4d\n", i + 1, p.getName(), p.getTotalPoints(), "/",
          p.getMaxPoints());
    }
  }

  private static void displayWinnerPickFrequencies(
      HashMap<String, TreeMap<String, Integer>> predictionMap) {

    System.out.format("%12s%12s%12s%12s%12s\n", "", WILD_CARD, DIVISIONAL, CONFERENCE, SUPER_BOWL);

    for(String team: predictionMap.get(WILD_CARD).keySet()) {
      System.out.format("%12s", team);
      for(String round: predictionMap.keySet()) {
        System.out.format("%12d", predictionMap.get(round).get(team));
      }
      System.out.format("\n");
    }
  }

  private static void updatePoints(Predictions correct, List<Predictions> predictions1,
      List<Predictions> predictions2, List<Predictions> predictions3) {
    for(Predictions p: predictions1) {
      p.updatePoints(correct);
    }
    for(Predictions p: predictions2) {
      if(!predictions1.contains(p)) {
        p.updatePoints(correct);
      }
    }
    for(Predictions p: predictions3) {
      if(!predictions1.contains(p) && !predictions2.contains(p)) {
        p.updatePoints(correct);
      }
    }
  }

  private static void populatePredictionMap(List<Predictions> predictionsList, String[] rounds,
      HashMap<String, TreeMap<String, Integer>> predictionMap) {
    for (String team : predictionMap.get(rounds[0]).keySet()) {
      for (Predictions p : predictionsList) {
        if (p.getWildCardPredictions().contains(team)) {
          predictionMap.get(rounds[0]).put(team, predictionMap.get(rounds[0]).get(team) + 1);
        }
        if (p.getDivisionalRoundPredictions().contains(team)) {
          predictionMap.get(rounds[1]).put(team, predictionMap.get(rounds[1]).get(team) + 1);
        }
        if (p.getConferenceTitlePredictions().contains(team)) {
          predictionMap.get(rounds[2]).put(team, predictionMap.get(rounds[2]).get(team) + 1);
        }
        if (p.getSuperbowlPredictions().contains(team)) {
          predictionMap.get(rounds[3]).put(team, predictionMap.get(rounds[3]).get(team) + 1);
        }
      }
    }
  }

  private static void initializePredictionMap(
      HashMap<String, TreeMap<String, Integer>> predictionMap) {
    TreeMap<String, Integer> wildCardPredictions = new TreeMap<>();
    TreeMap<String, Integer> divisionalPredictions = new TreeMap<>();
    TreeMap<String, Integer> conferencePredictions = new TreeMap<>();
    TreeMap<String, Integer> superBowlPredictions = new TreeMap<>();

    initializeRoundMap(wildCardPredictions);
    initializeRoundMap(divisionalPredictions);
    initializeRoundMap(conferencePredictions);
    initializeRoundMap(superBowlPredictions);

    predictionMap.put(WILD_CARD, wildCardPredictions);
    predictionMap.put(DIVISIONAL, divisionalPredictions);
    predictionMap.put(CONFERENCE, conferencePredictions);
    predictionMap.put(SUPER_BOWL, superBowlPredictions);
  }


  private static void initializeRoundMap(TreeMap<String, Integer> map) {
    map.put(RAVENS, 0);
    map.put(STEELERS, 0);
    map.put(BILLS, 0);
    map.put(BUCCANEERS, 0);
    map.put(RAMS, 0);
    map.put(SAINTS, 0);
    map.put(CHIEFS, 0);
    map.put(PACKERS, 0);
    map.put(SEAHAWKS, 0);
    map.put(BROWNS, 0);
    map.put(TITANS, 0);
    map.put(WASHINGTON, 0);
    map.put(BEARS, 0);
    map.put(COLTS, 0);
    map.put(BENGALS, 0);
    map.put(COWBOYS, 0);

  }

}
