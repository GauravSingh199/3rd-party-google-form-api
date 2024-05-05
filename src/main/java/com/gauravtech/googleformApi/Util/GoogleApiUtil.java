package com.gauravtech.googleformApi.Util;

import com.gauravtech.googleformApi.FormDto.CreateFormDto;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.forms.v1.Forms;
import com.google.api.services.forms.v1.FormsScopes;
import com.google.api.services.forms.v1.model.Form;
import com.google.api.services.forms.v1.model.Info;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class GoogleApiUtil {
    private static final String APPLICATION_NAME = "Google Forms API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens/path";
    private static final List<String> SCOPES = Arrays.asList(FormsScopes.FORMS_RESPONSES_READONLY,FormsScopes.DRIVE);
   // private static final List<String> SCOPES = Arrays.asList(FormsScopes .FORMS_RESPONSES_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "/client_secret_945056591363-ic12uama9rpb7thc7h6oglstpsv4vi4l.apps.googleusercontent.com.json";

    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
		// Load client secrets.
		InputStream in = GoogleApiUtil.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
		if (in == null) {
			throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
		}
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
				clientSecrets, SCOPES)
				.setDataStoreFactory(new FileDataStoreFactory(
						new java.io.File(System.getProperty("user.home"), TOKENS_DIRECTORY_PATH)))
				.setAccessType("offline").build();
		LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
		return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
	}
    
    //To perform any operation on Form 
    
    private Forms getformService() throws GeneralSecurityException, IOException {
		final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		Forms forms = new Forms.Builder(httpTransport, JSON_FACTORY,getCredentials(httpTransport)).setApplicationName(APPLICATION_NAME).build();
		return forms;
	}
    
    
    public String createForm(CreateFormDto createDto) throws IOException, GeneralSecurityException {
        Forms forms = getformService();

        Info title = createDto.getTitle();
       
       
     // Request body for creating a form
        Form newform = new Form();
        
        newform.setInfo(title);

        // Execute the request to create the form
        Form execute = forms.forms().create(newform).execute();

        String formId = execute.getFormId();
        // Return the ID of the created form
        return formId ;
    }
    
    
//--------------------------------------------------------------------------------------------------------------------------------------
//    public static void main(String[] args) throws IOException, GeneralSecurityException {
//        
//    }
}

