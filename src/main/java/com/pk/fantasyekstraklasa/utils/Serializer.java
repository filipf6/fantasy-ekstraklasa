package com.pk.fantasyekstraklasa.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.pk.fantasyekstraklasa.persistence.model.League;
import com.pk.fantasyekstraklasa.persistence.model.Player;
import com.pk.fantasyekstraklasa.persistence.model.User;
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
//    public static class UserSerializer extends JsonObjectSerializer<User> {
//        @Override
//        protected void serializeObject(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//            jsonGenerator.writeNumberField("id",user.getId());
//            jsonGenerator.writeStringField("name", user.getName());
//            jsonGenerator.writeStringField("surname", user.getSurname());
//            jsonGenerator.writeStringField("email", user.getEmail());
//            jsonGenerator.writeStringField("username", user.getUsername());
//            jsonGenerator.writeStringField("password",user.getPassword());
//            jsonGenerator.writeObjectField("createDate", user.getCreateDate());
//            jsonGenerator.writeObjectField("lastPasswordResetDate", user.getLastPasswordResetDate());
//        }
//    }
    public static class LeagueSerializer extends JsonObjectSerializer<League> {
        @Override
        protected void serializeObject(League league, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumberField("id",league.getId());
            jsonGenerator.writeStringField("name", league.getName());
        }
    }
}
