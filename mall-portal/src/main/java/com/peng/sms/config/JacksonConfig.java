package com.peng.sms.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * Jackson related configuration class
 * JSON will not return fields with null values
 */
@Configuration
public class JacksonConfig {

    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();

        // Configure the mapper so that all serialized objects follow this rule:
        // Include.ALWAYS -> default, serialize all fields
        // Include.NON_DEFAULT -> do not serialize fields with default values
        // Include.NON_EMPTY -> do not serialize fields that are empty ("") or null.
        // This reduces data usage for mobile clients.
        // Include.NON_NULL -> do not serialize fields that are null
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // Keep fields, convert null values to empty string (optional)
//        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>()
//        {
//            @Override
//            public void serialize(Object o, JsonGenerator jsonGenerator,
//                                  SerializerProvider serializerProvider)
//                    throws IOException, JsonProcessingException
//            {
//                jsonGenerator.writeString("");
//            }
//        });

        return objectMapper;
    }
}
