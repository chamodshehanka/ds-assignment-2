package com.fantastic4.restapi.service;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirebaseConfig {

    @Bean
    public Firestore getFirestore() {
        return FirestoreClient.getFirestore();
    }

}
