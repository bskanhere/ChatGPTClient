

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.service.OpenAiService;

import java.io.IOException;

public class ChatGPTClient {

    public static String getChatGPTResponse(String prompt) throws IOException {
        String apiKey = "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";

        String model = "text-davinci-002";
        OpenAiService service = new OpenAiService(apiKey);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(prompt)
                .model(model)
                .maxTokens(2049)
                .echo(true)
                .build();
        CompletionResult result = service.createCompletion(completionRequest);
        result.getChoices().forEach(System.out::println);
        return result.getChoices().get(0).getText();
    }
}