package com.example.testsample;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.std.StdDeserializer;
import org.codehaus.jackson.type.JavaType;
import org.joda.time.LocalDate;

import java.io.IOException;

public class fetchData extends StdDeserializer<LocalDate> {


    protected fetchData()
    {
        super(LocalDate.class);
    }
    protected fetchData(Class<?> vc) {
        super(vc);
    }

    protected fetchData(JavaType valueType) {
        super(valueType);
    }

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String text=jsonParser.getText();
        if (text == null)
        {
            return null;
        }

        return new LocalDate(text);



    }
}