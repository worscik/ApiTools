package pl.apidoisender;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SendService {

    private static Logger logger = LogManager.getLogger(SendService.class);

    public static final String URL = "URL";
    public static final String CLIENTID = "CLIENT";
    public static final String API_KEY = "APIKEY";
    public static final String SHA = "SHA";
    public static final String OWNER = "OWNER";

    public static void main(String[] args) throws IOException {

        File file = new File("file.csv");
        Scanner scanner = new Scanner(file);
        RestTemplate restTemplate = new RestTemplate();


        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] splitedLine = line.split(";");
            String email = splitedLine[0];
            String emailId = splitedLine[1];

            Request request = new Request.Builder()
                    .withClintId(CLIENTID)
                    .withApiKey(API_KEY)
                    .withSha(SHA)
                    .withOwner(OWNER)
                    .withEmail(email)
                    .withDoubleOptInEmailId(emailId)
                    .build();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Request> requestEntity = new HttpEntity<>(request, headers);

            try {
                ResponseEntity<ResponseEmailSend> result = restTemplate.postForEntity(URL, requestEntity, ResponseEmailSend.class);
                if (result.getStatusCode().is2xxSuccessful()) {
                    if(result.getBody().isSuccess()){
                        logger.info("Successes send email to: " + email + " with ID: " + emailId + ". Result: " +
                                result.getBody());
                    } else {
                        logger.error("Error during  send email to " + email + " with ID: " + emailId + ". Result: "
                                + result.getBody());
                    }
                } else {
                    logger.error("Cannot send email to " + email + " with ID: " + emailId + ". Result: " + result.getBody());
                }
            } catch (Exception e) {
                logger.error("error during send an email: " + e);
            }
        }
        scanner.close();
    }

}
