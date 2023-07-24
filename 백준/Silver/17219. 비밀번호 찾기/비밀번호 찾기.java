import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 저장된 사이트 주소의 수
            int M = Integer.parseInt(st.nextToken()); // 비밀번호를 찾으려는 사이트 주소의 수
            Map<String, String> info = new HashMap<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                info.put(st.nextToken(), st.nextToken());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                bw.write(info.get(st.nextToken()) + "\n");
            }
            bw.flush();
        } catch (IOException e) {
            System.out.println("IOException error");
        } catch (Exception e) {
            System.out.println("Exception error");
        }
    }
}
