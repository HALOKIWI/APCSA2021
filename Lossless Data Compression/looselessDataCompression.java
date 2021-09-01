import java.util.ArrayList;
import java.util.HashMap;

public class looselessDataCompression {
    public static void main(String[] args) throws Exception {
        String str = "Looking, Booking, Cooking, Planning";
        HashMap<String, ArrayList<Integer>> patternMap = findPattern(str);

        for (HashMap.Entry<String, ArrayList<Integer>> entry : patternMap.entrySet()) {
            System.out.print(entry.getKey() + " ");
            System.out.println(entry.getValue());
        }
        HashMap<String, String> replaceMap = buildReplaceMap(patternMap);

    }

    public static HashMap<String, ArrayList<Integer>> findPattern(String str) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        boolean[] strAvailability = new boolean[str.length()];// check if character is taken by pattern

        for (int patternLength = str.length() / 3; patternLength >= 2; patternLength--) {
            // for (int patternLength = 2; patternLength <= str.length() / 2;
            // patternLength++) {

            for (int pos = 0; pos <= str.length() - patternLength; pos++) {
                String pattern = str.substring(pos, pos + patternLength);
                // System.out.println(pattern);

                if (map.containsKey(pattern)) {
                    // pattern is find again
                    ArrayList<Integer> patternPosList = map.get(pattern);

                    if (patternPosList.size() == 1) {
                        int prevPatternPos = patternPosList.get(0);// find first position

                        if (checkStringAvailability(strAvailability, prevPatternPos, prevPatternPos + patternLength)
                                && checkStringAvailability(strAvailability, pos, pos + patternLength)
                                && prevPatternPos + patternLength <= pos) {

                            patternPosList.add(pos);
                            map.put(pattern, patternPosList);
                        }
                    } else if (patternPosList.size() == 2) {
                        int firstPatternPos = patternPosList.get(patternPosList.size() - 2);
                        int secondPatternPos = patternPosList.get(patternPosList.size() - 1);

                        if (checkStringAvailability(strAvailability, firstPatternPos, firstPatternPos + patternLength)
                                && checkStringAvailability(strAvailability, secondPatternPos,
                                        secondPatternPos + patternLength)
                                && checkStringAvailability(strAvailability, pos, pos + patternLength)
                                && firstPatternPos + patternLength <= secondPatternPos
                                && secondPatternPos + patternLength <= pos) {// find longest

                            setStringAvailability(strAvailability, firstPatternPos, firstPatternPos + patternLength);
                            setStringAvailability(strAvailability, secondPatternPos, secondPatternPos + patternLength);
                            setStringAvailability(strAvailability, pos, pos + patternLength);
                            patternPosList.add(pos);
                            map.put(pattern, patternPosList);
                        }

                    } else if (checkStringAvailability(strAvailability, pos, pos + patternLength)) {// longer dont need
                                                                                                    // to determine
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

        map.entrySet().removeIf(entry -> entry.getValue().size() <= 2);

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

    private static HashMap<String, String> buildReplaceMap(HashMap<String, ArrayList<Integer>> patternMap) {
        String[] characterList = { "!", "@", "$", "%", "^", "#", "&", "*" };
        int count = 0;
        HashMap<String, String> map = new HashMap<>();

        for (HashMap.Entry<String, ArrayList<Integer>> entry : patternMap.entrySet()) {
            map.put(entry.getKey(), characterList[count % 8]);

        }
        return map;
    }

}