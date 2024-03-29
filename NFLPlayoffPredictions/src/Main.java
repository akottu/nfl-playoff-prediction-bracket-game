import java.util.*;
import java.io.*;

public class Main {

        public static Map<String, Predictions> user_predictions;
        public static Set<String> valid_teams;
        public static String data_path;
        public static String[] rounds;

        public static void main(String[] args) throws Exception {
                // Initialize variables
                user_predictions = new HashMap<>();
                valid_teams = new HashSet<>();
                data_path = new File("").getAbsolutePath() + "/NFLPlayoffPredictions/data";
                rounds = new String[] { "Wild Card", "Divisional", "Conference", "Superbowl" };
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

                        File file = new File(data_path + "/2022_predictions.txt");
                        Scanner scanner = new Scanner(new FileReader(file));

                        while (scanner.hasNextLine()) {
                                String user = scanner.nextLine().trim();
                                List<String> wildCardRound = new ArrayList<String>(
                                                Arrays.asList(scanner.nextLine().split(", ")));
                                List<String> divisionalRound = new ArrayList<String>(
                                                Arrays.asList(scanner.nextLine().split(", ")));
                                List<String> conferenceRound = new ArrayList<String>(
                                                Arrays.asList(scanner.nextLine().split(", ")));
                                List<String> superbowlRound = new ArrayList<String>(
                                                Arrays.asList(scanner.nextLine().split(", ")));

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
//                results2021();
                predictions2022();
        }

        // IDK WHAT THIS DOES?
        private static void predictions2022() {
                List<Predictions> roland_glen_predictions = new ArrayList<>();
                List<Predictions> hitch_route_panel_predictions = new ArrayList<>();
                List<Predictions> hitch_route_pool_predictions = new ArrayList<>();

                roland_glen_predictions.add(user_predictions.get("Adit Acharya 1"));
                roland_glen_predictions.add(user_predictions.get("Akash Krishna 1"));
                roland_glen_predictions.add(user_predictions.get("Anish Kottu 1"));
                roland_glen_predictions.add(user_predictions.get("Arjun Keshava 1"));
                roland_glen_predictions.add(user_predictions.get("Ashwin Inala 1"));
                roland_glen_predictions.add(user_predictions.get("Brian Wu 1"));
                roland_glen_predictions.add(user_predictions.get("Girish Ganesh 1"));
                roland_glen_predictions.add(user_predictions.get("Mayur Krishna 1"));
                roland_glen_predictions.add(user_predictions.get("Sid Moorthy 1"));
                roland_glen_predictions.add(user_predictions.get("Sujay Kestur 1"));
                roland_glen_predictions.add(user_predictions.get("Will Furth 1"));

                hitch_route_panel_predictions.add(user_predictions.get("Alex Frumkin 1"));
                hitch_route_panel_predictions.add(user_predictions.get("Anish Kottu 1"));
                hitch_route_panel_predictions.add(user_predictions.get("Cary Shindell 1"));
                hitch_route_panel_predictions.add(user_predictions.get("Rob Palmisano 1"));

                hitch_route_pool_predictions.add(user_predictions.get("Aayush Goradia 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Aayush Goradia 2"));
                hitch_route_pool_predictions.add(user_predictions.get("Adit Acharya 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Akash Krishna 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Alex Frumkin 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Alex Frumkin 2"));
                hitch_route_pool_predictions.add(user_predictions.get("Allan Chen 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Anish Kottu 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Anish Kottu 2"));
                hitch_route_pool_predictions.add(user_predictions.get("Anish Kottu 3"));
                hitch_route_pool_predictions.add(user_predictions.get("Cade McCurdy 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Carson Beck 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Cary Shindell 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Chaz Beauchamp 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Christian Cleaveland 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Daniel Rub 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Devin McCarthy 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Dylan Zumar 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Edward Frumkin 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Eric Andresen 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Geo Janer 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Hunter Kaufman 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Hunter Kaufman 2"));
                hitch_route_pool_predictions.add(user_predictions.get("Jack Neumann 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Jake Brandberg 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Jay Chandar 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Jayson Latady 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Jayson Latady 2"));
                hitch_route_pool_predictions.add(user_predictions.get("Jayson Latady 3"));
                hitch_route_pool_predictions.add(user_predictions.get("Jesse Kireyev 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Jesse Kireyev 2"));
                hitch_route_pool_predictions.add(user_predictions.get("Jordan McGilvery 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Josh Young 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Jule Cuasay 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Mahish Kewalramani 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Marazzano Colon 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Matt Pearson 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Michael Zheng 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Mihir Patel 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Mohammad Khatami 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Nathan Parikh 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Nick Oleinik 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Peter Wang 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Rahul Ramesh 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Ram Bala 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Ravi Gandhi 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Rick Palmisano 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Rob Palmisano 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Robert Paul 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Sahil Tandon 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Sam Auld 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Sanjay Ravindra 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Sean Keating 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Sean Naughton 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Shanrick Mullings 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Shanrick Mullings 2"));
                hitch_route_pool_predictions.add(user_predictions.get("Shanrick Mullings 3"));
                hitch_route_pool_predictions.add(user_predictions.get("Stephanie Wiehe 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Stephanie Wiehe 2"));
                hitch_route_pool_predictions.add(user_predictions.get("Surya Tumbapura 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Sydney Aquilina 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Thomas Williford 1"));
                hitch_route_pool_predictions.add(user_predictions.get("TJ Sadler 1"));
                hitch_route_pool_predictions.add(user_predictions.get("Weyman Cohen 1"));

                HashMap<String, TreeMap<String, Integer>> roland_glen_prediction_map = new HashMap<>();
                initializePredictionMap(roland_glen_prediction_map);
                populatePredictionMap(roland_glen_predictions, rounds, roland_glen_prediction_map);
                System.out.println();
                System.out.format("%60s\n", "RG WINNER FREQUENCIES");
                System.out.println();
                displayWinnerPickFrequencies(roland_glen_prediction_map);

                HashMap<String, TreeMap<String, Integer>> hitch_route_panel_prediction_map =
                    new HashMap<>();
                initializePredictionMap(hitch_route_panel_prediction_map);
                populatePredictionMap(hitch_route_panel_predictions, rounds, hitch_route_panel_prediction_map);
                System.out.println();
                System.out.format("%60s\n", "HITCH ROUTE PANEL WINNER FREQUENCIES");
                System.out.println();
                displayWinnerPickFrequencies(hitch_route_panel_prediction_map);

                HashMap<String, TreeMap<String, Integer>> hitch_route_pool_prediction_map =
                    new HashMap<>();
                initializePredictionMap(hitch_route_pool_prediction_map);
                populatePredictionMap(hitch_route_pool_predictions, rounds,
                    hitch_route_pool_prediction_map);
                System.out.println();
                System.out.format("%60s\n", "HITCH ROUTE POOL WINNER FREQUENCIES");
                System.out.println();
                displayWinnerPickFrequencies(hitch_route_pool_prediction_map);

                roland_glen_predictions.add(user_predictions.get("CHALK -"));
                hitch_route_panel_predictions.add(user_predictions.get("CHALK -"));
                hitch_route_pool_predictions.add(user_predictions.get("CHALK -"));

                updatePoints(
                                user_predictions.get("CORRECT"),
                                roland_glen_predictions,
                                hitch_route_panel_predictions,
                                hitch_route_pool_predictions);

                Collections.shuffle(roland_glen_predictions);
                Collections.shuffle(hitch_route_panel_predictions);
                Collections.shuffle(hitch_route_pool_predictions);

                Collections.sort(roland_glen_predictions, Collections.reverseOrder());
                Collections.sort(hitch_route_panel_predictions, Collections.reverseOrder());
                Collections.sort(hitch_route_pool_predictions, Collections.reverseOrder());


                System.out.println("\n\n");

                System.out.format("%39s\n", "RG STANDINGS");
                System.out.println();
                for (int i = 0; i < roland_glen_predictions.size(); i++) {
                        Predictions p = roland_glen_predictions.get(i);
                        System.out.format("%3d%25s%5d%2s%4d\n", i + 1, p.getName(), p.getTotalPoints(), "/",
                                        p.getMaxPoints());
                }
                System.out.println("\n\n");

                System.out.format("%39s\n", "HITCH ROUTE PANEL STANDINGS");
                System.out.println();
                for (int i = 0; i < hitch_route_panel_predictions.size(); i++) {
                        Predictions p = hitch_route_panel_predictions.get(i);
                        System.out.format("%3d%25s%5d%2s%4d\n", i + 1, p.getName(), p.getTotalPoints(), "/",
                            p.getMaxPoints());
                }
                System.out.println("\n\n");

                System.out.format("%39s\n", "HITCH ROUTE POOL STANDINGS");
                System.out.println();
                for (int i = 0; i < hitch_route_pool_predictions.size(); i++) {
                        Predictions p = hitch_route_pool_predictions.get(i);
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

                System.out.format("%12s%12s%12s%12s%12s\n", "", "Wild Card", "Divisional", "Conference", "Superbowl");

                for (String team : predictionMap.get("Wild Card").keySet()) {
                        System.out.format("%12s", team);
                        for (String round : rounds) {
                                if(round.equals(rounds[0]) && (team.equals("PACKERS") || team.equals("TITANS"))) {
                                        System.out.format("%12s", "--");
                                } else {
                                        System.out.format("%12d", predictionMap.get(round).get(team));
                                }
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

                predictionMap.put("Wild Card", wildCardPredictions);
                predictionMap.put("Divisional", divisionalPredictions);
                predictionMap.put("Conference", conferencePredictions);
                predictionMap.put("Superbowl", superBowlPredictions);
        }

        private static void initializeRoundMap(TreeMap<String, Integer> map) {
                for (String team : valid_teams) {
                        map.put(team, 0);
                }
        }

}
