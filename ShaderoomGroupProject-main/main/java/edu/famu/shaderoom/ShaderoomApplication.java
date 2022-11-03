package edu.famu.shaderoom;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;

@SpringBootApplication
public class ShaderoomApplication {

    public static void main(String[] args) {
        ClassLoader loader = ShaderoomApplication.class.getClassLoader();

//opens the file stored in resources
        File file = new File(loader.getResource("serviceAccountKey.json").getFile());
//reads the data from the file
        FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());

//connect to Firebase
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initalizeApp(options);

        SpringApplication.run(ShaderoomApplication.class, args);
    }

}
