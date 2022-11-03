package services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import models.PurchaseOrder;
import models.User;
import models.BaseChats;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class PurchaseOrderService
{
public List<PurchaseOrder> getPurchaseOrderByUserId(String id) throws ExecutionException, InterruptedException
        {

        List<PurchaseOrder> purchaseOrder =new ArrayList<>();

        //database connection object
        Firestore db=FirestoreClient.getFirestore();

        //retrieves a reference to the document(row) of the collection (table) with a specific id
        DocumentReference userRef=db.collection("User").document(id);

        //ApiFuture allows us to make async calls to the database
        ApiFuture<DocumentSnapshot> future=userRef.get();
        //Retrieve document
        DocumentSnapshot userDoc=future.get();
        //Convert JSON into User class object
        User user = userDoc.toObject(User.class);

        //Query for post by user
        Query postQuery=db.collectionGroup("Purchase Order").whereEqualTo("createdBy",userRef);
        ApiFuture<QuerySnapshot> querySnapshot=postQuery.get();

        //loop over results and create Purchase order objects
        for(DocumentSnapshot document:querySnapshot.get().getDocuments())
        {
        purchaseOrder.add(new PurchaseOrder(document.getId(),
                (Number)document.get("poNumber"),
                document.getTimestamp("poDate"),
                document.getTimestamp("promisedDate"),
                (Map)document.get("shipTo"),
                (BaseChats)document.get("vendor"),
                (ArrayList<String>) document.get("items"),
                document.getString("shippingMethod"),
                (Number) document.get("freightCost"),
                (Number) document.get("taxRate"),
                (Number) document.get("discountRate"),
                (Number) document.get("invoiceNumber"),
                document.getString("specialInstructions"),
                document.getString("status"),
                (User) document.get("createdBy"),
                (User) document.get("approvedBy"),
                document.getTimestamp("createdAt"),
                document.getTimestamp("updatedAt"),
                user));
        }

        return purchaseOrder;

        }

    public String createPurchaseOrder( PurchaseOrder purchaseOrder) throws ExecutionException, InterruptedException{
        //database connection object
        Firestore db=FirestoreClient.getFirestore();
        ApiFuture<DocumentReference> postRef=db.collection("Purchase Order").add(purchaseOrder);
        return postRef.get().getId();

        }

}
