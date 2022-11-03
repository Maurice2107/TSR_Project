package edu.example.shaderoom.services;

@Service
public class UserService {

    public List<Chats> getChatsByUserId(String objectId) throws ExecutionEception, INterruptedException {

        //printing out chats to the screen
        List<Chats> chats = new Arraylist<>();

        //database connection object
        Firestore db = FirestoreClient.getFirestore();

        //retrieves a reference to the document(row) of the collection (table) with a specific id
        DocumentReference userRef = db.collection("User").document(id);

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
            chats.add(new Chats(document.getId(), document.getString("title"), document.getString("content"), document.getDate("createdAt"),user)
            );
        }

        return chats;




    }
}
