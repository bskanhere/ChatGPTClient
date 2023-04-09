

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

import java.io.IOException;

public class ChatGPTClient {

    public static void main(String[] args) throws IOException {
        String endpoint = "https://api.openai.com/v1/completions";
        String apiKey = "your-api-key";

        String prompt = "Write java class file to find fibonacci number";
        String model = "text-davinci-002";
        OpenAiService service = new OpenAiService(apiKey);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(prompt)
                .model(model)
                .maxTokens(2049)
                .echo(true)
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}