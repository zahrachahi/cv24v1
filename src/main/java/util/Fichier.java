package util;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Fichier {

    private Resource resource;

    public Fichier() {

        this.resource = new DefaultResourceLoader().getResource("smallCV.xml");
    }

    public String loadFileXML() {
    	
        try {
        	
            InputStream inputStream = resource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            
            while ((line = reader.readLine()) != null) {
            	
                stringBuilder.append(line).append("\n");
            }
            
            return stringBuilder.toString();
            
        } catch (IOException e) {
        	
            return "Erreur lors de la lecture du fichier XML : " + e.getMessage();
        }
    }
}
