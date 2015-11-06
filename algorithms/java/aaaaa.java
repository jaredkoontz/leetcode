import java.util.*;

/**
 * Created by Jared on 11/5/2015.
 */
public class aaaaa {
    import java.util.*;


    public class Problem {

        public static void main(String[] a) {
//        Scanner in = new Scanner(System.in);
//        int numInputs = in.nextInt();
//        in.nextLine();
//        ArrayList<String> inputs = getInput(in, numInputs);
            ArrayList<String> inputs = getInputHardCoded();
            HashMap<String, ArrayList<Integer>> index = createIndex(inputs);
            ArrayList<String> queries = getQueriesHardCoded();
//        int numQueries = in.nextInt();
//        in.nextLine();
//        ArrayList<String> queries = getQueries(in, numQueries);
            runQueries(index, queries);
        }


        private static void runQueries(HashMap<String, ArrayList<Integer>> index, ArrayList<String> queries) {
            for (String q : queries) {
                q = q.replaceAll("\\s+", ""); //remove whitespace
                String[] query = understandQuery(q);
                //keep original query
                boolean andFlag = false, orFlag = false;
                if (q.contains("&")) {
                    andFlag = true;
                }
                if (q.contains("|")) {
                    orFlag = true;
                }
                runQuery(andFlag, orFlag, query, index);
            }
        }

        private static void runQuery(boolean andFlag, boolean orFlag, String[] query, HashMap<String, ArrayList<Integer>> index) {
            if (query.length == 1) {
                //simply run query
                ArrayList<Integer> result = index.get(query[0]);
                outputResult(result);
            } else {
                ArrayList<Integer> result1 = index.get(query[0]);
                ArrayList<Integer> result2 = index.get(query[1]);

                if (orFlag) {

                    ArrayList<Integer> result = combineResultsOr(result1, result2);
                    outputResult(result);
                }
                if (andFlag) {
                    ArrayList<Integer> result = combineResultsAnd(result1, result2);
                    outputResult(result);
                }
            }
        }

        //todo assumes lists are the same size, need to find larger one?
        private static ArrayList<Integer> combineResultsAnd(ArrayList<Integer> first, ArrayList<Integer> second) {
            first.retainAll(second);
            Collections.sort(first);
            return first;
        }

        private static ArrayList<Integer> combineResultsOr(ArrayList<Integer> first, ArrayList<Integer> second) {
            for (Integer num : second) {      // iterate through the second list
                if (!first.contains(num)) {   // if first list doesn't contain current element
                    first.add(num);          // add it to the first list
                }
            }
            return first;
        }

        private static void outputResult(ArrayList<Integer> result) {
            for (Integer docNumber : result)
                System.out.print(docNumber + " ");
            System.out.println();
        }

        // todo always a space between & and | ?
        private static String[] understandQuery(String q) {
            return q.split("\\||&");
        }

        private static HashMap<String, ArrayList<Integer>> createIndex(ArrayList<String> inputs) {
            HashMap<String, ArrayList<Integer>> index = new HashMap<>();
            int documentNumber = 1;
            for (String input : inputs) {
                String[] tokens = input.split(" ");
                addTokensToIndex(index, tokens, documentNumber);
                documentNumber++;
            }
            return index;
        }

        //todo word might appear once already
        private static void addTokensToIndex(HashMap<String, ArrayList<Integer>> index, String[] tokens, int documentNumber) {
            for (String word : tokens) {
                ArrayList<Integer> documentsAppearedIn = index.get(word);
                if (documentsAppearedIn == null) {
                    documentsAppearedIn = new ArrayList<>();
                    documentsAppearedIn.add(documentNumber);
                    index.put(word, documentsAppearedIn);
                } else {
                    if(!documentsAppearedIn.contains(documentNumber)) {
                        documentsAppearedIn.add(documentNumber);
                        index.put(word, documentsAppearedIn);
                    }
                }
            }
        }

        private static ArrayList<String> getQueries(Scanner in, int numQueries) {
            ArrayList<String> holder = new ArrayList<>();
            for (int i = 0; i < numQueries; i++) {
                String line = in.nextLine();
                holder.add(line);
            }
            return holder;
        }


        private static ArrayList<String> getInputHardCoded() {
            return new ArrayList(Arrays.asList(new String[]{"online transaction application accounting internship position",
                    "keep records of money and negotiable instruments involved in a financial institution and various transactions receive and pay out money", "position requires previous cash handling sales and customer service experience member service associates assist columbia credit union members in reaching",
                    "ability to work a schedule that includes working weekends and some holidays the nationwide mortgage licensing system nmls web site mortgage",
                    "minimum of six months cash handling experience tellers primary responsibilities include processing transactions accurately and efficiently in accordance with",
                    "high school diploma or equivalent the fifthlargest bank in the united states were one of the countrys most respected innovative and successful financial",
                    "you may check the status of your application online 24 hours a day 7 days a week through usajobs by signing in and selecting quot application status",
                    "responsible for reviewing new loan application requests to ensure that all required forms andor documentation have been provided by the borrower",
                    "accurately and efficiently process transactions such as customer deposits and cashing checks minimum of six months cash handling experience",
                    "may be required to work weekends andor extended hours and regular reliable attendance is critical ability to demonstrate initiative a commitment to"}));
        }

        private static ArrayList<String> getQueriesHardCoded() {
            return new ArrayList(Arrays.asList(new String[]{
                    "financial",
                    "weekends | holidays",
                    "accurately & transactions",
                    "accurately & fart"
            }));
        }

        //todo
        private static ArrayList<String> getInput(Scanner in, int numLines) {
            ArrayList<String> holder = new ArrayList<>();
            for (int i = 0; i < numLines; i++) {
                String line = in.nextLine();
                holder.add(line);
            }
            return holder;
        }
    }

}
