package com.gpt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        // Set ChatGPT endpoint and API key
        String endpoint = "https://chat.openai.com/";
        String apiKey = "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";

        // Prompt user for input string
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your message: ");
            String input = reader.readLine();

            // Send input to ChatGPT API and display response
            String response = ChatBot.sendQuery(input, endpoint, apiKey);
            LOGGER.info("Response: {}", 
            		response);
        } catch (IOException e) {
            LOGGER.error("Error reading input: {}", e.getMessage());
        } catch (JSONException e) {
            LOGGER.error("Error parsing API response: {}", e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Unexpected error: {}", e.getMessage());
        }
    }
}
