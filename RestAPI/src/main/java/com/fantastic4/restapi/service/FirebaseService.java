package com.fantastic4.restapi.service;

import com.fantastic4.restapi.dto.SensorDTO;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FirebaseService {

    Firestore db = FirestoreClient.getFirestore();

    public String addSensorData(SensorDTO sensorDTO) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionApiFuture = db
                .collection("sensors")
                .document()
                .set(sensorDTO);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

}
