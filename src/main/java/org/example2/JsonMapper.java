package org.example2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonMapper  {
    String pathToJson;

    public void mapJSON(String pathToJson) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//        JSON file to Java object
        List<Language> obj = mapper.readValue(new File(pathToJson),

                new TypeReference<ArrayList<Language>>() {
                });

        System.out.println(obj.get(0).getLanguage());
        System.out.println(obj.get(1).getLanguage());

    }



}
