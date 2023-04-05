import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class ChatGPTClient {

    public static void main(String[] args) throws IOException {
        String endpoint = "https://api.openai.com/v1/engine/davinci-codex/completions";
        String apiKey = "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";

        String prompt = "Hello, how are you?";
        int maxTokens = 50;

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(endpoint);

        StringEntity params = new StringEntity(
                "{\"prompt\":\"" + prompt + "\",\"max_tokens\":" + maxTokens + "}",
                ContentType.APPLICATION_JSON);
        request.setEntity(params);

        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey);
        request.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        HttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();

        String result = EntityUtils.toString(entity);
        System.out.println(result);
    }
}