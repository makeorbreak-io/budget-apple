package com.budgetapple.pidrobe.core.services;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Miguel Cardoso
 * @project pidrobe
 */
public class RestService extends Thread {

    /**
     * Constructor
     *
     */
    public RestService() {

    }

    JSONObject sendGet(String url) throws IOException, ParseException {
        String response = consumeAppRest(url);
        return parseJsonObjResponse(response);
    }

    /**
     * Performs a GET request using Apache httpClient.
     *
     * @return response output string
     * @throws IOException
     */
    private String consumeAppRest(String url) throws IOException {
        // create HTTP Client
        HttpClient httpClient = HttpClientBuilder.create().build();

        // Create new getRequest with constructed URL
        HttpGet getRequest = new HttpGet(url);

        // Execute request and catch response
        HttpResponse response = httpClient.execute(getRequest);

        // Check for HTTP response code: 200 = success
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
        }

        // Get-Capture Complete body response
        BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
        String line;
        StringBuilder output = new StringBuilder();

        while ((line = br.readLine()) != null) {
            output.append(line);
        }

        return output.toString();
    }

    /**
     * Will parse Json Reservation Response.
     *
     * @param jsonMessage String with Json Message
     * @return Json object
     * @throws ParseException
     */
    private JSONObject parseJsonObjResponse(String jsonMessage) throws ParseException, IOException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(jsonMessage);
        JSONObject jsonObject = (JSONObject) obj;

        return jsonObject;
    }
}

