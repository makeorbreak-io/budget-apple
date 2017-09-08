package core;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Miguel Cardoso
 * @project pidrobe
 */
public class RestClient extends Thread {

    private static final String APPLICATION_SERVER_URL = "http://localhost:8080/rest";

    private static final String CONTROLLER_ACCESS_GET_URL = "https://newsapi.org/v1/articles?source=techcrunch&apiKey=2d183a8bd561481aba8065ae504d88ac";

    private static final int CONNECTION_SLEEP_TIME = 5000;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");

    /**
     * Constructor
     *
     */
    public RestClient() {

    }

    //TESTING PURPOSES
    public static void main(String[] args) {
        RestClient restClient = new RestClient();
        restClient.start();
    }

    /**
     * Run method.
     * <p>
     * In cycles with sleep time, it will perform a GET Request.
     */
    public void run() {
        while (true) {
            try {
                String response = consumeAppRest(CONTROLLER_ACCESS_GET_URL);

                System.out.println(response);
                parseJsonResponse(response);


            } catch (IOException e) {
                //   System.out.println("Server did not respond. Trying again in " + (CONNECTION_SLEEP_TIME / 1000) + " seconds.");
            } catch (ParseException e) {
                System.out.println("Json message came corrupted.");
                e.printStackTrace();
            }


            try {
                // System.out.println("---------------------------- SLEEPING --------------------------------");

                sleep(CONNECTION_SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
     * @return List of Reservations read.
     * @throws ParseException
     */
    private void parseJsonResponse(String jsonMessage) throws ParseException, IOException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(jsonMessage);
        JSONObject jsonObject = (JSONObject) obj;

        JSONArray list = (JSONArray) jsonObject.get("reservations");
    }
}

