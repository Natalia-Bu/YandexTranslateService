import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private final static String API_KEY = "trnsl.1.1.20180707T161001Z.e0d88504f1adbc53.ee3b41ef473202df50ac44bdbd7002734729ec62";
    private final static String URL = "https://translate.yandex.net/api/v1.5/tr/translate";
    private final static String lang = "en-ru";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        System.out.println("Print phrase in english:");
        System.out.println("To stop the program print 'stop!'");
        do {
            str = br.readLine();
            if (!str.equals("stop!")) {
                Document response = Jsoup.connect(URL).data("key", API_KEY, "text", str, "lang", lang).get();
                System.out.println(response.getElementsByTag("text").text());
            }
        } while (!str.equals("stop!"));
    }
}
