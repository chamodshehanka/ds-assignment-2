package com.fantastic4.restapi.service;

import com.fantastic4.restapi.dto.SensorDTO;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

@Service
public class FirebaseService {

    //    @Autowired
    private final Firestore firestore = FirestoreClient.getFirestore();
//    Firestore firestore = new FirebaseInitialize().getFirestore();
//Firestore firestore = FirebaseInitialize.firestore;
    private CollectionReference getSensorCollection() {
        return firestore.collection("sensors");
    }

    public String addSensorData(SensorDTO sensorDTO) throws ExecutionException, InterruptedException {
//        ApiFuture<WriteResult> collectionApiFuture = getSensorCollection()
//                .document().set(sensorDTO);
        HashMap<String, String> sensor = new HashMap<>();
        sensor.put("sensorId", sensorDTO.getSensorId());
        sensor.put("floorNo", sensorDTO.getFloorNo());
        System.out.println("dureksha : "+ firestore
                .collection("sensors")
                .document("doc1")
                .set(sensor));
        ApiFuture<WriteResult> collectionApiFuture = firestore.collection("sensors").document("doc1")
                .set(sensor);
        System.out.println("Collection API Future" + collectionApiFuture);

//       collectionApiFuture.get().getUpdateTime().toString();

        return "done" ;
    }

}
