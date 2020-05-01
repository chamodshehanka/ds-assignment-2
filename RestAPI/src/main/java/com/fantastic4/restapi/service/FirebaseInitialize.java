package com.fantastic4.restapi.service;

import com.fantastic4.restapi.dto.SensorDTO;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class FirebaseInitialize {

    static Firestore firestore;

    @PostConstruct
    public void initialize() {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream("./serviceAccountKey.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://online-organizer-caefa.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
            firestore = FirestoreClient.getFirestore();
        } catch (Exception e) {
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

    public SensorDTO getSensorByID(String sensorID) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = firestore
                .collection("sensors")
                .document(sensorID);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        SensorDTO sensorDTO = null;

        DocumentSnapshot document = future.get();
        if (document.exists()) {
            sensorDTO = document.toObject(SensorDTO.class);
        }

        return sensorDTO;
    }

    public String updateSensorData(SensorDTO sensorDTO) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> future = firestore
                .collection("sensors")
                .document(sensorDTO.getSensorId())
                .set(sensorDTO);
        return future.get().getUpdateTime().toString();
    }

    public String deleteSensorData(String sensorID) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> future = firestore
                .collection("sensors")
                .document(sensorID).delete();

        return future.get().getUpdateTime().toString();
    }

    public ArrayList<SensorDTO> getAllSensors() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> futures = firestore
                .collection("sensors").get();

        ArrayList<SensorDTO> sensorDTOArrayList = new ArrayList<>();

        List<QueryDocumentSnapshot> documents = futures.get().getDocuments();
        documents.forEach(doc -> {
            sensorDTOArrayList.add(doc.toObject(SensorDTO.class));
        });

        return sensorDTOArrayList;
    }
}
