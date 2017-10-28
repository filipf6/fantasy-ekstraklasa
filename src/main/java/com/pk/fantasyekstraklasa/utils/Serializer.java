package com.pk.fantasyekstraklasa.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.pk.fantasyekstraklasa.persistence.model.Player;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.jackson.JsonObjectSerializer;

import java.io.IOException;

@JsonComponent
public class Serializer {
    public static class PlayerSerializer extends JsonObjectSerializer<Player> {
        @Override
        protected void serializeObject(Player player, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumberField("id",player.getId());
            jsonGenerator.writeStringField("name", player.getName());
            jsonGenerator.writeStringField("surname", player.getSurname());
            jsonGenerator.writeStringField("position", player.getPosition().toString());
            jsonGenerator.writeNumberField("price", player.getPrice());
            jsonGenerator.writeBooleanField("injury", player.isInjury());
        }
    }
}
