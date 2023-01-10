package edu.example.shaderoom.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;

import edu.example.shaderoom.models.Chat;
import edu.example.shaderoom.models.Comment;
import edu.example.shaderoom.models.RestChats;
import edu.example.shaderoom.models.User;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ChatService {

    public Chat getChatsById(String objectId)throws ExecutionException, InterruptedException{
        Chat chats =null;

        //database connection object
        Firestore db = FirestoreClient.getFirestore();

        //retrieves a reference to the document(row) of the collection (table) with a specific id
        DocumentReference chatsRef = db.collection("Chats").document(objectId);

        //ApiFuture allows us to make async calls to the database
        ApiFuture<DocumentSnapshot> future = chatsRef.get();
        //Retrieve document
        DocumentSnapshot document = future.get();

        //convert JSON into Chats class object
        if(document.exists())
        {
            UserService service = new UserService();
            DocumentReference userRef = (DocumentReference) document.get("author");
            ApiFuture<DocumentSnapshot> userQuery = userRef.get();
            DocumentSnapshot userDoc = userQuery.get();
            User user = userDoc.toObject(User.class);

            chats = new Chat(document.getId(),document.getString("title"), document.getString("content"), document.getDate("createdAt"),user);
        }

        return chats;

    }
    public List<Chat> getChatsTopic(String topic)throws ExecutionException, InterruptedException{

        ArrayList<Chat> chats = null;


            //database connection object
            Firestore db = FirestoreClient.getFirestore();



            //Query for post by post
            Query topicQuery = db.collectionGroup("Chats").whereEqualTo("topic", topic);
            ApiFuture<QuerySnapshot> querySnapshot = topicQuery.get();

            //loop over results and create Comment objects
            for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
                //convert JSON into Chats class object
                if (document.exists()) {
                    UserService service = new UserService();
                    DocumentReference userRef = (DocumentReference) document.get("author");
                    ApiFuture<DocumentSnapshot> userQuery = userRef.get();
                    DocumentSnapshot userDoc = userQuery.get();
                    User user = userDoc.toObject(User.class);

                    chats.add(new Chat(document.getId(), document.getString("title"), document.getString("content"), document.getDate("createdAt"), user));
                }
            }



        return chats;

    }
    public List<Comment> getChatsComments(String id)throws ExecutionException, InterruptedException{

        Chat chats = getChatsById(id);

        if(chats != null)
        {
            List<Comment> comments = new ArrayList<>();
            //database connection object
            Firestore db = FirestoreClient.getFirestore();

            //retrieves a reference to the document(row) of the collection (table) with a specific id
            DocumentReference postRef = db.collection("Chats").document(id);

            //Query for post by post
            Query commentQuery = db.collectionGroup("Comment").whereEqualTo("Chats", chats);
            ApiFuture<QuerySnapshot> querySnapshot = commentQuery.get();

            //loop over results and create Comment objects
            for(DocumentSnapshot document : querySnapshot.get().getDocuments())
            {
                User author;

                DocumentReference authorRef = (DocumentReference) document.get("author");
                //ApiFuture allows us to make async calls to the database
                ApiFuture<DocumentSnapshot> future = authorRef.get();
                //Retrieve document
                DocumentSnapshot authorDoc = future.get();

                if(authorDoc.exists())
                    author = authorDoc.toObject(User.class);
                else
                {
                    author = new User();
                    author.setUserName("unknown");
                }
                DocumentReference chatRef = (DocumentReference) document.get("chat");
                ApiFuture<DocumentSnapshot> future2 = chatRef.get();
                //Retrieve document
                DocumentSnapshot chatDoc = future2.get();
                //add the comment to the list
                Chat chat = chatDoc.toObject(Chat.class);
                comments.add(new Comment(document.getId(),(int)document.get("likeCount"), document.getString("content"),document.getDate("createdAt"), author, chat));
            }

            return comments;
        }
        return null;
    }

    public String createPost(RestChats chats) throws ExecutionException, InterruptedException{
        //database connection object
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<DocumentReference> chatsRef = db.collection("Chats").add(chats);
        return chatsRef.get().getId();
    }


}
