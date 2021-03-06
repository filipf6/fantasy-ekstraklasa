package com.pk.fantasyekstraklasa.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.pk.fantasyekstraklasa.persistence.model.*;
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
    public static class UserSerializer extends JsonObjectSerializer<User> {
        @Override
        protected void serializeObject(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumberField("id",user.getId());
            jsonGenerator.writeStringField("name", user.getName());
            jsonGenerator.writeStringField("surname", user.getSurname());
            jsonGenerator.writeStringField("email", user.getEmail());
            jsonGenerator.writeStringField("password",user.getPassword());
            jsonGenerator.writeObjectField("createDate", user.getCreateDate());
            jsonGenerator.writeBooleanField("enabled", user.isEnabled());
            jsonGenerator.writeObjectField("lastPasswordResetDate", user.getLastPasswordResetDate());
//            jsonGenerator.writeNumberField("budget",user.getBudget());
        }
    }
    public static class LeagueSerializer extends JsonObjectSerializer<League> {
        @Override
        protected void serializeObject(League league, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumberField("id",league.getId());
            jsonGenerator.writeStringField("name", league.getName());
        }
    }

    public static class TeamSerializer extends JsonObjectSerializer<Team> {
        @Override
        protected void serializeObject(Team team, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumberField("id",team.getId());
            jsonGenerator.writeStringField("name", team.getName());
            jsonGenerator.writeObjectField("budget", team.getBudget());
        }
    }

    public static class PlayerTeamSerializer extends JsonObjectSerializer<PlayerTeam> {
        @Override
        protected void serializeObject(PlayerTeam playerTeam, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumberField("id",playerTeam.getId());
            jsonGenerator.writeObjectField("player", playerTeam.getPlayer());
            jsonGenerator.writeBooleanField("firstSquad", playerTeam.isFirstSquad());
            jsonGenerator.writeBooleanField("captain", playerTeam.isCaptain());
            jsonGenerator.writeBooleanField("viceCaptain", playerTeam.isViceCaptain());
            if(playerTeam.getAccuratePosition()==null) jsonGenerator.writeStringField("accuratePosition", null);
            else jsonGenerator.writeStringField("accuratePosition", playerTeam.getAccuratePosition().toString());
        }
    }
}
