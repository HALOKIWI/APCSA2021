import java.util.ArrayList;
import java.util.HashMap;

public class looselessDataCompression {
    public static void main(String[] args) throws Exception {
        String str = "computer science is becoming a competitive industry.";
        HashMap<String, ArrayList<Integer>> patternMap = findPattern(str);

        for (HashMap.Entry<String, ArrayList<Integer>> entry : patternMap.entrySet()) {
            System.out.print(entry.getKey() + " ");
            System.out.println(entry.getValue());
        }

    }

    public static HashMap<String, ArrayList<Integer>> findPattern(String str) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        boolean[] strAvailability = new boolean[str.length()];

        for (int patternLength = str.length() / 2; patternLength >= 2; patternLength--) {
            for (int pos = 0; pos <= str.length() - patternLength; pos++) {
                String pattern = str.substring(pos, pos + patternLength);
                // System.out.println(pattern);

                if (map.containsKey(pattern)) {
                    // pattern is find again
                    ArrayList<Integer> patternPosList = map.get(pattern);

                    if (patternPosList.size() == 1) {
                        int prevPatternPos = patternPosList.get(patternPosList.size() - 1);

                        if (checkStringAvailability(strAvailability, prevPatternPos, prevPatternPos + patternLength)
                                && checkStringAvailability(strAvailability, pos, pos + patternLength)
                                && prevPatternPos + patternLength <= pos) {

                            setStringAvailability(strAvailability, prevPatternPos, prevPatternPos + patternLength);
                            setStringAvailability(strAvailability, pos, pos + patternLength);
                            patternPosList.add(pos);
                            map.put(pattern, patternPosList);
                        }
                    } else if (checkStringAvailability(strAvailability, pos, pos + patternLength)) {
                        setStringAvailability(strAvailability, pos, pos + patternLength);
                        patternPosList.add(pos);
                        map.put(pattern, patternPosList);
                    }

                } else {
                    ArrayList<Integer> patternPosList = new ArrayList<>();
                    patternPosList.add(pos);
                    map.put(pattern, patternPosList);
                }

                // System.out.println(map);
            }
        }

        map.entrySet().removeIf(entry -> entry.getValue().size() == 1);

        return map;
    }

    private static boolean checkStringAvailability(boolean[] strAvailability, int startPos, int endPos) {
        for (int i = startPos; i < endPos; i++) {
            if (strAvailability[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean[] setStringAvailability(boolean[] strAvailability, int startPos, int endPos) {
        for (int i = startPos; i < endPos; i++) {
            strAvailability[i] = true;
        }
        return strAvailability;
    }
}