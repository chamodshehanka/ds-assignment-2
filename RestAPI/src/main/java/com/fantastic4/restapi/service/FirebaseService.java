package com.fantastic4.restapi.service;

import com.fantastic4.restapi.dto.SensorDTO;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class FirebaseService {


    private Firestore firestore;

    private CollectionReference getSensorCollection() {
        return firestore.collection("sensors");
    }

    public String addSensorData(SensorDTO sensorDTO) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionApiFuture = getSensorCollection()
                .document().set(sensorDTO);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

}
