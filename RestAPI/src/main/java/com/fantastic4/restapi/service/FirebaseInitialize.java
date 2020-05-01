package com.fantastic4.restapi.service;

import com.fantastic4.restapi.dto.SensorDTO;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.util.concurrent.ExecutionException;

@Service
public class FirebaseInitialize {

    static Firestore firestore;

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

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String addSensorData(SensorDTO sensorDTO) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionApiFuture = firestore
                .collection("sensors")
                .document(sensorDTO.getSensorId())
                .set(sensorDTO);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public SensorDTO getSensor(String sensorID) {
        DocumentReference documentReference = firestore
                .collection("sensors")
                .document(sensorID);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        SensorDTO sensorDTO = null;
        try {
            DocumentSnapshot document = future.get();
            if (document.exists()) {
                sensorDTO = document.toObject(SensorDTO.class);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return sensorDTO;
    }
}
