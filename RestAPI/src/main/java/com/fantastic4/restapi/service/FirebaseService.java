package com.fantastic4.restapi.service;

import com.fantastic4.restapi.dto.SensorDTO;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

@Service
public class FirebaseService {

    //    @Autowired
//    private Firestore firestore = FirestoreClient.getFirestore();
    Firestore firestore = new FirebaseInitialize().getFirestore();

    private CollectionReference getSensorCollection() {
        return firestore.collection("sensors");
    }

    public String addSensorData(SensorDTO sensorDTO) throws ExecutionException, InterruptedException {
//        ApiFuture<WriteResult> collectionApiFuture = getSensorCollection()
//                .document().set(sensorDTO);
        HashMap<String, String> sensor = new HashMap<>();
        sensor.put("sensorId", sensorDTO.getSensorId());
        sensor.put("floorNo", sensorDTO.getFloorNo());
        System.out.println("Sensor DTO : " + sensorDTO.getFloorNo());
        ApiFuture<WriteResult> collectionApiFuture = firestore.collection("sensors").document("doc1")
                .set(sensor);
        System.out.println("Collection API Future" + collectionApiFuture);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

}
