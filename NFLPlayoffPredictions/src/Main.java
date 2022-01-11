import java.util.*;
import java.io.*;

public class Main {

        public static final String WILD_CARD = "Wild Card";
        public static final String DIVISIONAL = "Divisional";
        public static final String CONFERENCE = "Conference";
        public static final String SUPER_BOWL = "Super Bowl";

        public static Map<String, Predictions> user_predictions;
        public static Set<String> valid_teams;
        public static String data_path;

        public static void main(String[] args) throws Exception {
                // Initialize variables
                user_predictions = new HashMap<>();
                valid_teams = new HashSet<>();
                data_path = new File("").getAbsolutePath() + "/NFLPlayoffPredictions/data";

                // Load teams from nfl_teams.txt
                try {
                        System.out.println("Loading Teams:");
                        System.out.println("--------------------------------------");

                        File file = new File(data_path + "/nfl_teams.txt");
                        Scanner scanner = new Scanner(new FileReader(file));

                        while (scanner.hasNextLine()) {
                                valid_teams.add(scanner.nextLine());
                        }

                } catch (FileNotFoundException ex) {
                        throw new Exception(ex);
                } catch (Exception ex) {
                        throw new Exception(ex);
                }

                System.out.println(valid_teams.toString());
                System.out.println("\n");

                // Load User Brackets from data/2021_results.txt
                try {
                        System.out.println("Loading Brackets:");
                        System.out.println("--------------------------------------");

                        File file = new File(data_path + "/2021_results.txt");
                        Scanner scanner = new Scanner(new FileReader(file));

                        while (scanner.hasNextLine()) {
                                String user = scanner.nextLine().trim();
                                List<String> wildCardRound = new ArrayList<String>(
                                                Arrays.asList(scanner.nextLine().split(",")));
                                List<String> divisionalRound = new ArrayList<String>(
                                                Arrays.asList(scanner.nextLine().split(",")));
                                List<String> conferenceRound = new ArrayList<String>(
                                                Arrays.asList(scanner.nextLine().split(",")));
                                List<String> superbowlRound = new ArrayList<String>(
                                                Arrays.asList(scanner.nextLine().split(",")));

                                Predictions bracket = new Predictions(user, wildCardRound, divisionalRound,
                                                conferenceRound, superbowlRound, 0);
                                user_predictions.put(user, bracket);
                                System.out.println(String.format("%s's bracket:", user));
                                System.out.println("R1: " + wildCardRound.toString());
                                System.out.println("R2: " + divisionalRound.toString());
                                System.out.println("R3: " + conferenceRound.toString());
                                System.out.println("R4: " + superbowlRound.toString());
                                System.out.println("-----------------------------------");

                                if (scanner.hasNextLine())
                                        scanner.nextLine();
                        }
                } catch (FileNotFoundException ex) {
                        throw new Exception(ex);
                } catch (Exception ex) {
                        throw new Exception(ex);
                }
                results2021();
        }

        // IDK WHAT THIS DOES?
        private static void idkwhatthisdoes() {
                List<Predictions> roland_glen_predictions = new ArrayList<>();
                List<Predictions> hitch_route_panel_predictions = new ArrayList<>();
                List<Predictions> hitch_route_pool_predictions = new ArrayList<>();

                roland_glen_predictions.add(user_predictions.get("Anish Kottu 1"));
                hitch_route_panel_predictions.add(user_predictions.get("Anish Kottu 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Anish Kottu 1"));

                String[] rounds = { WILD_CARD, DIVISIONAL, CONFERENCE, SUPER_BOWL };

                HashMap<String, TreeMap<String, Integer>> roland_glen_prediction_map = new HashMap<>();
                initializePredictionMap(roland_glen_prediction_map);
                populatePredictionMap(roland_glen_predictions, rounds, roland_glen_prediction_map);
                System.out.println();
                System.out.format("%60s\n", "RG WINNER FREQUENCIES");
                System.out.println();
                displayWinnerPickFrequencies(roland_glen_prediction_map);

                roland_glen_predictions.add(user_predictions.get("CHALK"));
                hitch_route_panel_predictions.add(user_predictions.get("CHALK"));
                hitch_route_pool_predictions.add(user_predictions.get("CHALK"));

                updatePoints(
                                user_predictions.get("CORRECT"),
                                roland_glen_predictions,
                                hitch_route_panel_predictions,
                                hitch_route_pool_predictions);

                Collections.shuffle(roland_glen_predictions);

                Collections.sort(roland_glen_predictions, Collections.reverseOrder());

                System.out.println("\n\n");

                System.out.format("%39s\n", "RG STANDINGS");
                System.out.println();
                for (int i = 0; i < roland_glen_predictions.size(); i++) {
                        Predictions p = roland_glen_predictions.get(i);
                        System.out.format("%3d%25s%5d%2s%4d\n", i + 1, p.getName(), p.getTotalPoints(), "/",
                                        p.getMaxPoints());
                }

                System.out.println("\n\n");
        }

        private static void results2021() {
                List<Predictions> rgPredictionsList = new ArrayList<>();
                List<Predictions> shotPredictionsList = new ArrayList<>();
                List<Predictions> bettingPool = new ArrayList<>();

                rgPredictionsList.add(user_predictions.get("Ram G"));
                rgPredictionsList.add(user_predictions.get("Jay"));
                rgPredictionsList.add(user_predictions.get("Alex F"));

                shotPredictionsList.add(user_predictions.get("Ram G"));

                bettingPool.add(user_predictions.get("Ram G"));
                bettingPool.add(user_predictions.get("Jay"));
                bettingPool.add(user_predictions.get("Alex F"));

                String[] rounds = { WILD_CARD, DIVISIONAL, CONFERENCE, SUPER_BOWL };

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

                updatePoints(user_predictions.get("CORRECT"), rgPredictionsList, shotPredictionsList, bettingPool);

                Collections.shuffle(rgPredictionsList);
                Collections.shuffle(shotPredictionsList);
                Collections.shuffle(bettingPool);

                Collections.sort(rgPredictionsList, Collections.reverseOrder());
                Collections.sort(shotPredictionsList, Collections.reverseOrder());
                Collections.sort(bettingPool, Collections.reverseOrder());

                // display all point totals

                System.out.println("\n\n");

                System.out.format("%28s\n", "RG STANDINGS");
                System.out.println();
                for (int i = 0; i < rgPredictionsList.size(); i++) {
                        Predictions p = rgPredictionsList.get(i);
                        System.out.format("%2d%15s%5d%2s%4d\n", i + 1, p.getName(),
                                        p.getTotalPoints(), "/",
                                        p.getMaxPoints());
                }

                System.out.println("\n\n");

                System.out.format("%28s\n", "THE SHOT STANDINGS");
                System.out.println();
                for (int i = 0; i < shotPredictionsList.size(); i++) {
                        Predictions p = shotPredictionsList.get(i);
                        System.out.format("%2d%15s%5d%2s%4d\n", i + 1, p.getName(),
                                        p.getTotalPoints(), "/",
                                        p.getMaxPoints());
                }

                System.out.println("\n\n");

                System.out.format("%28s\n", "BETTING POOL STANDINGS");
                System.out.println("\n\n");
                for (int i = 0; i < bettingPool.size(); i++) {
                        Predictions p = bettingPool.get(i);
                        System.out.format("%2d%15s%5d%2s%4d\n", i + 1, p.getName(),
                                        p.getTotalPoints(), "/",
                                        p.getMaxPoints());
                }
        }

        private static void displayWinnerPickFrequencies(
                        HashMap<String, TreeMap<String, Integer>> predictionMap) {

                System.out.format("%12s%12s%12s%12s%12s\n", "", WILD_CARD, DIVISIONAL, CONFERENCE, SUPER_BOWL);

                for (String team : predictionMap.get(WILD_CARD).keySet()) {
                        System.out.format("%12s", team);
                        for (String round : predictionMap.keySet()) {
                                System.out.format("%12d", predictionMap.get(round).get(team));
                        }
                        System.out.format("\n");
                }
        }

        private static void updatePoints(Predictions correct, List<Predictions> predictions1,
                        List<Predictions> predictions2, List<Predictions> predictions3) {
                for (Predictions p : predictions1) {
                        p.updatePoints(correct);
                }
                for (Predictions p : predictions2) {
                        if (!predictions1.contains(p)) {
                                p.updatePoints(correct);
                        }
                }
                for (Predictions p : predictions3) {
                        if (!predictions1.contains(p) && !predictions2.contains(p)) {
                                p.updatePoints(correct);
                        }
                }
        }

        private static void populatePredictionMap(List<Predictions> predictionsList, String[] rounds,
                        HashMap<String, TreeMap<String, Integer>> predictionMap) {
                for (String team : predictionMap.get(rounds[0]).keySet()) {
                        for (Predictions p : predictionsList) {
                                if (p.getWildCardPredictions().contains(team)) {
                                        predictionMap.get(rounds[0]).put(team,
                                                        predictionMap.get(rounds[0]).get(team) + 1);
                                }
                                if (p.getDivisionalRoundPredictions().contains(team)) {
                                        predictionMap.get(rounds[1]).put(team,
                                                        predictionMap.get(rounds[1]).get(team) + 1);
                                }
                                if (p.getConferenceTitlePredictions().contains(team)) {
                                        predictionMap.get(rounds[2]).put(team,
                                                        predictionMap.get(rounds[2]).get(team) + 1);
                                }
                                if (p.getSuperbowlPredictions().contains(team)) {
                                        predictionMap.get(rounds[3]).put(team,
                                                        predictionMap.get(rounds[3]).get(team) + 1);
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
                for (String team : valid_teams) {
                        map.put(team, 0);
                }
        }

}
