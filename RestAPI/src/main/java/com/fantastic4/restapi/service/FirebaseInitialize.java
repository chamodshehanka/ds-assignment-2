package com.fantastic4.restapi.service;

import com.fantastic4.restapi.dto.*;
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

    public String addSensor(Sensor sensor) throws ExecutionException, InterruptedException {
        System.out.println(sensor.getSensorID());
        System.out.println(sensor.getFloorNo());
        System.out.println(sensor.getRoomNo());
        System.out.println(sensor.getLatestCO2Level());
        System.out.println(sensor.getLatestSmokeLevel());

        ApiFuture<WriteResult> collectionApiFuture = firestore
                .collection("sensors")
                .document(sensor.getSensorID())
                .set(sensor);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public String addSensorData(SensorData sensorData) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionApiFuture = firestore
                .collection("sensorData")
                .document(sensorData.getSensorDataID())
                .set(sensorData);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public String addRoom(Room room) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionApiFuture = firestore
                .collection("rooms")
                .document(room.getRoomNo())
                .set(room);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public String addAdmin(Admin admin) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionApiFuture = firestore
                .collection("admins")
                .document(admin.getAdminID())
                .set(admin);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public String addFloor(Floor floor) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collectionApiFuture = firestore
                .collection("floors")
                .document(floor.getFloorID())
                .set(floor);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public Sensor getSensorByID(String sensorID) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = firestore
                .collection("sensors")
                .document(sensorID);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        Sensor sensor = null;

        DocumentSnapshot document = future.get();
        if (document.exists()) {
            sensor = document.toObject(Sensor.class);
        }

        return sensor;
    }

    public SensorData getSensorDataByID(String id) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = firestore
                .collection("sensorData")
                .document("sensorData")
                .collection(id)
                .document("PBMFtgsGm3aivlibW54b");
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        SensorData sensorData = null;

        DocumentSnapshot document = future.get();
        if (document.exists()) {
            sensorData = document.toObject(SensorData.class);
        }
        return sensorData;
    }

    public Room getRoomByID(String id) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = firestore
                .collection("rooms")
                .document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        Room room = null;

        DocumentSnapshot document = future.get();
        if (document.exists()) {
            room = document.toObject(Room.class);
        }

        return room;
    }

    public Admin getAdminByID(String id) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = firestore
                .collection("admins")
                .document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        Admin admin = null;

        DocumentSnapshot document = future.get();
        if (document.exists()) {
            admin = document.toObject(Admin.class);
        }

        return admin;
    }

    public Floor getFloorByID(String id) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = firestore
                .collection("floors")
                .document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        Floor floor = null;

        DocumentSnapshot snapshot = future.get();

        if (snapshot.exists()) {
            floor = snapshot.toObject(Floor.class);
        }

        return floor;
    }

    public String updateSensor(Sensor sensor) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> future = firestore
                .collection("sensors")
                .document(sensor.getSensorID())
                .set(sensor);
        return future.get().getUpdateTime().toString();
    }

    public String updateSensorData(SensorData sensorData) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> future = firestore
                .collection("sensorData")
                .document(sensorData.getSensorDataID())
                .set(sensorData);
        return future.get().getUpdateTime().toString();
    }

    public String updateRoom(Room room) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> future = firestore
                .collection("rooms")
                .document(room.getRoomNo())
                .set(room);
        return future.get().getUpdateTime().toString();
    }

    public String updateAdmin(Admin admin) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> future = firestore
                .collection("admins")
                .document(admin.getAdminID())
                .set(admin);
        return future.get().getUpdateTime().toString();
    }

    public String updateFloor(Floor floor) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> future = firestore
                .collection("floors")
                .document(floor.getFloorID())
                .set(floor);

        return future.get().getUpdateTime().toString();
    }

    public String deleteSensor(String sensorID) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> future = firestore
                .collection("sensors")
                .document(sensorID).delete();

        return future.get().getUpdateTime().toString();
    }

    public String deleteSensorData(String id) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> future = firestore
                .collection("sensorData")
                .document(id).delete();

        return future.get().getUpdateTime().toString();
    }

    public String deleteRoom(String id) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> future = firestore
                .collection("rooms")
                .document(id).delete();

        return future.get().getUpdateTime().toString();
    }

    public String deleteAdmin(String id) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> future = firestore
                .collection("admins")
                .document(id).delete();

        return future.get().getUpdateTime().toString();
    }

    public String deleteFloor(String id) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> future = firestore
                .collection("floors")
                .document(id).delete();

        return future.get().getUpdateTime().toString();
    }

    public ArrayList<Sensor> getAllSensors() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> futures = firestore
                .collection("sensors").get();

        ArrayList<Sensor> sensorArrayList = new ArrayList<>();

        List<QueryDocumentSnapshot> documents = futures.get().getDocuments();
        documents.forEach(doc -> {
            System.out.println(doc.get("sen"));
            sensorArrayList.add(doc.toObject(Sensor.class));
        });

        return sensorArrayList;
    }

    public ArrayList<SensorData> getAllSensorData() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> futures = firestore
                .collection("sensors")
                .document("S001")
                .collection("sensorData").orderBy("date")
                .get();

        ArrayList<SensorData> sensorDataArrayList = new ArrayList<>();

        List<QueryDocumentSnapshot> documents = futures.get().getDocuments();
        documents.forEach(doc -> {
            sensorDataArrayList.add(doc.toObject(SensorData.class));
        });

        return sensorDataArrayList;
    }

    public ArrayList<SensorData> getAllLatestSensorData() throws ExecutionException, InterruptedException {
        ArrayList<SensorData> sensorDataLatestArrayList = new ArrayList<>();

        ArrayList<Sensor> sensorArrayList = getAllSensors();
        sensorArrayList.forEach((sensor) -> {
            ApiFuture<QuerySnapshot> futures = firestore
                    .collection("sensors")
                    .document(sensor.getSensorID())
                    .collection("sensorData").orderBy("date")
                    .limit(1)
                    .get();

            List<QueryDocumentSnapshot> documents = null;
            try {
                documents = futures.get().getDocuments();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            assert documents != null;
            documents.forEach(doc -> {
                sensorDataLatestArrayList.add(doc.toObject(SensorData.class));
            });
        });

        return sensorDataLatestArrayList;
    }

    public ArrayList<Room> getAllRooms() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> futures = firestore
                .collection("rooms").get();

        ArrayList<Room> roomArrayList = new ArrayList<>();

        List<QueryDocumentSnapshot> documents = futures.get().getDocuments();
        documents.forEach(doc -> {
            roomArrayList.add(doc.toObject(Room.class));
        });

        return roomArrayList;
    }

    public ArrayList<Admin> getAllAdmins() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> futures = firestore
                .collection("admins").get();

        ArrayList<Admin> adminArrayList = new ArrayList<>();

        List<QueryDocumentSnapshot> documents = futures.get().getDocuments();
        documents.forEach(doc -> {
            adminArrayList.add(doc.toObject(Admin.class));
        });

        return adminArrayList;
    }

    public ArrayList<Floor> getAllFloors() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> futures = firestore
                .collection("floors").get();

        ArrayList<Floor> floorArrayList = new ArrayList<>();

        List<QueryDocumentSnapshot> documents = futures.get().getDocuments();
        documents.forEach(doc -> {
            floorArrayList.add(doc.toObject(Floor.class));
        });

        return floorArrayList;
    }

    public String login(Admin admin) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = firestore
                .collection("admins")
                .document(admin.getAdminID());
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        Admin adminOb = null;

        DocumentSnapshot document = future.get();
        if (document.exists()) {
            adminOb = document.toObject(Admin.class);
        }

        assert adminOb != null;
        if (admin.getPassword().equals(adminOb.getPassword()) ){
            return "true";
        }

        return "false";
    }
}
