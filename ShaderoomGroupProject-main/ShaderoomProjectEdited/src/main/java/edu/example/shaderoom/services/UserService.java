package edu.example.shaderoom.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;

import edu.example.shaderoom.models.Chat;
import edu.example.shaderoom.models.User;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    public List<Chat> getChatsByUserId(String objectId) throws ExecutionException, InterruptedException {

        //printing out chats to the screen
        List<Chat> chats = new ArrayList<>();

        //database connection object
        Firestore db = FirestoreClient.getFirestore();

        //retrieves a reference to the document(row) of the collection (table) with a specific id
        DocumentReference userRef = db.collection("User").document(objectId);

        //ApiFuture allows us to make async calls to the database
        ApiFuture<DocumentSnapshot> future = userRef.get();
        //Retrieve document
        DocumentSnapshot userDoc = future.get();
        //Convert JSON into User class object
        User user = userDoc.toObject(User.class);

        //query for chats by user
        Query chatsQuery = db.collectionGroup("Chats").whereEqualTo("author", userRef);
        ApiFuture<QuerySnapshot> querySnapshot = chatsQuery.get();

        //loop over results and creat chat objects
        for(DocumentSnapshot document : querySnapshot.get().getDocuments())
        {
            chats.add(new Chat(document.getId(), document.getString("title"), document.getString("content"), document.getDate("createdAt"),user)
            );
        }
        return chats;




    }
}
