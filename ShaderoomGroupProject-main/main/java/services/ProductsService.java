package services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import models.Products;
import models.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class ProductsService {

    public Products getProductById(String id)throws ExecutionException, InterruptedException{
        Products products = null;
        //database connection object
        Firestore db = FirestoreClient.getFirestore();

        //retrieves a reference to the document(row) of the collection (table) with a specific id
        DocumentReference postRef = db.collection("Products").document(id);

        //ApiFuture allows us to make async calls to the database
        ApiFuture<DocumentSnapshot> future = postRef.get();
        //Retrieve document
        DocumentSnapshot document = future.get();

        //Convert JSON into Post class object
        if(document.exists())
        {
            UserService service = new UserService();

            DocumentReference userRef = (DocumentReference) document.get(id);
            ApiFuture<DocumentSnapshot> userQuery = userRef.get();
            DocumentSnapshot userDoc = userQuery.get();
           User user= userDoc.toObject(User.class);

            products =  new Products((Number)document.get("sku"),
                    document.getString("name") ,
                    document.getString("content"),
                    document.getString("description") ,
                    document.get("unit"));
        }


        return products;

    }

    public String createProduct( Products products) throws ExecutionException, InterruptedException{
        //database connection object
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<DocumentReference> postRef = db.collection("Products").add(products);
        return postRef.get().getId();
    }
}
