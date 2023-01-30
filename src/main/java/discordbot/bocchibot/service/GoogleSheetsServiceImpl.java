package discordbot.bocchibot.service;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

@Service
public class GoogleSheetsServiceImpl implements GoogleSheetsService {
    private static Sheets sheetsService;
    private static final String APPLICATION_NAME = "BocchiData";
    private static final String SPREADSHEET_ID = "18j-HTs2_HkXhg9a8EGr9emFBmqyCPjKWD7-mGFlnyWw";


    @Override
    public Credential authorize() throws GeneralSecurityException, IOException {
        InputStream in = GoogleSheetsServiceImpl.class.getResourceAsStream("/credentials.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(GsonFactory.getDefaultInstance(), new InputStreamReader(in));
        List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), GsonFactory.getDefaultInstance(), clientSecrets, scopes)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
        return credential;
    }

    @Override
    public Sheets getSheetsService() throws GeneralSecurityException, IOException {
        Credential credential = authorize();
        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), GsonFactory.getDefaultInstance(), credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    @Override
    public void getValues() throws GeneralSecurityException, IOException {
        sheetsService = getSheetsService();
        ValueRange response = sheetsService.spreadsheets().values()
                .get(SPREADSHEET_ID, "Sheet1")
                .execute();
        List<List<Object>> values = response.getValues();
        values.remove(0);
        System.out.println(values);

    }

    @Override
    public void appendData(String name, String npm) throws GeneralSecurityException, IOException {
        sheetsService = getSheetsService();
        ValueRange appendBody = new ValueRange()
                .setValues(Arrays.asList(
                        Arrays.asList(name, npm)
                ));
        sheetsService.spreadsheets().values()
                .append(SPREADSHEET_ID, "Sheet1", appendBody)
                .setValueInputOption("USER_ENTERED")
                .setInsertDataOption("INSERT_ROWS")
                .setIncludeValuesInResponse(true)
                .execute();
    }
}
