package services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import models.User;
import models.BaseChats;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Service
class VendorService {
    public BaseChats getVendorById(String id)throws ExecutionException, InterruptedException{
        BaseChats vendor = null;
        //database connection object
        Firestore db = FirestoreClient.getFirestore();

        //retrieves a reference to the document(row) of the collection (table) with a specific id
        DocumentReference postRef = db.collection("Vendor").document(id);

        //ApiFuture allows us to make async calls to the database
        ApiFuture<DocumentSnapshot> future = postRef.get();
        //Retrieve document
        DocumentSnapshot document = future.get();

        //Convert JSON into Post class object
        if(document.exists())
        {
            UserService service = new UserService();

            DocumentReference userRef = (DocumentReference) document.get("vendorId");
            ApiFuture<DocumentSnapshot> userQuery = userRef.get();
            DocumentSnapshot userDoc = userQuery.get();
            User user = userDoc.toObject(User.class);

            vendor =  new BaseChats(document.getString("vendorId"),
                    document.getString("company") ,
                    document.getString("content"),
                    (ArrayList<String>) document.get("street"),
                    document.getString("city") ,
                    document.getString("state"),
                    document.getString("postalCode"),
                    document.getString("country"),
                    document.getString("contact"),
                    document.getString("phoneNumber"),
                    document.getString("emailAddress"),
                    document.getString("paymentTerms"),
                    user);
        }


        return vendor;

    }

    public String createVendor( BaseChats vendor) throws ExecutionException, InterruptedException{
        //database connection object
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<DocumentReference> postRef = db.collection("Vendor").add(vendor);
        return postRef.get().getId();
    }
}
