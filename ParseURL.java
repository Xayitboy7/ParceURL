import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseURL {
  public static void main(String[] args) {
      try {
            URL url = new URL("https://google.com");
            URLConnection connection = url.openConnection(); 
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
            String html = stringBuilder.toString();
            extractTags(html); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void extractTags(String html) { 
        Pattern pattern = Pattern.compile("<\\s*([^\\s>/]+)");
        Matcher matcher = pattern.matcher(html);
        int count = 0;
        while (matcher.find()) {
            String tag = matcher.group(1);
            count++;
            System.out.println(tag);
        }
        System.out.println("number of tegs: "+count);
    }
}