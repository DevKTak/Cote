

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 생태학
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Float> map = new HashMap<>();

        float count = 0f;

        String str = "";

        while((str= bf.readLine())!=null){
            map.put(str, map.getOrDefault(str,0f)+1f);
            count++;
        }


        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for(String key : keys){
            System.out.print(key+" ");
            System.out.println(String.format("%.4f",map.get(key)/count*100));
        }
    }
}
