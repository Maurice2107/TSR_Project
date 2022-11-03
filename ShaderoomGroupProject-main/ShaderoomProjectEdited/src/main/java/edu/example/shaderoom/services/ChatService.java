package edu.example.shaderoom.services;

@Service
public class ChatService {

    public Chats getChatsById(String objectId)throws ExcecutionException, InterruptedException{
        Chats chats =null;

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
            SocumentSnapshot userDoc = userQuery.get();
            User user = userDoc.toObject(User.class);

            chats = new Chats(document.getId(),document.getString("title"), document.getString("content"), document.getDate("createdAt"),user);
        }

        return chats;

    }

    public List<Comment> getChatsComments(String id)throws ExecutionException, InterruptedException{

        Chats chats = getChatsById(id);

        if(chats != null)
        {
            List<Comment> comments = new ArrayList<>();
            //database connection object
            Firestore db = FirestoreClient.getFirestore();

            //retrieves a reference to the document(row) of the collection (table) with a specific id
            DocumentReference postRef = db.collection("Chats").document(id);

            //Query for post by post
            Query commentQuery = db.collectionGroup("Comment").whereEqualTo("Chats", chatsRef);
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
                    author.setUsername("unknown");
                }

                //add the comment to the list
                comments.add(new Comment(document.getId(), document.getString("content"), document.getNumber("likeCount"),document.getDate("createdAt"), author, post));
            }

            return comments;
        }
        return null;
    }

    public String createPost(RestPost post) throws ExecutionException, InterruptedException{
        //database connection object
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<DocumentReference> chatsRef = db.collection("Chats").add(chats);
        return chatsRef.get().getId();
    }


}
