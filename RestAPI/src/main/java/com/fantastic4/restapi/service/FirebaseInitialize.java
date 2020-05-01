package com.fantastic4.restapi.service;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

@Service
public class FirebaseInitialize {

    Firestore firestore;

    @PostConstruct
    public void initialize() {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream("./serviceAccountKey.json");
            System.out.println(serviceAccount.available());
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://online-organizer-caefa.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
            firestore = FirestoreClient.getFirestore();

            FirebaseInitialize firebaseInitialize = new FirebaseInitialize();
            HashMap<String, String> message = firebaseInitialize.getMessage();
            ApiFuture<WriteResult> future = firestore
                    .collection("sample").document("doc1")
                    .set(message);
            System.out.println("Successfully Updated! " + future.get().getUpdateTime());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public HashMap<String, String> getMessage() throws IOException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("hello", "chamod");
        return hashMap;
    }

    public Firestore getFirestore(){
        return firestore;
    }
}
