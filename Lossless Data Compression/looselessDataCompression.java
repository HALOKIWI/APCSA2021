import java.util.HashMap;
import java.util.Map;

public class looselessDataCompression {
    public static void main(String[] args) {
        findPattern("ababa");
    }

    public static HashMap<String, Integer> findPattern(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = str.length(); i >= 2; i--) {
            for (int j = 0; j <= str.length() - i; j++) {
                String pattern = str.substring(j, j + i);
                System.out.println(pattern);
                if (map.containsKey(pattern)) {
                    int count = map.get(pattern);
                    count++;
                    map.put(pattern,count);
        

                }else{
                    map.put(pattern,1);
                }
            }

        }
        return map;

    }

}