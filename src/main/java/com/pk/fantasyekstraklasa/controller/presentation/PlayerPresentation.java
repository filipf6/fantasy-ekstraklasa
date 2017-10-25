package com.pk.fantasyekstraklasa.controller.presentation;

import com.pk.fantasyekstraklasa.persistence.model.Player;
import com.pk.fantasyekstraklasa.persistence.model.utils.Position;

public class PlayerPresentation {
    private Long id;
    private String name;
    private String surname;
    private Position position;
    private Double price;
    private boolean injury;

    public PlayerPresentation(Player player) {
        this.id = player.getId();
        this.name = player.getName();
        this.surname = player.getSurname();
        this.position = player.getPosition();
        this.price = player.getPrice();
        this.injury = player.isInjury();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isInjury() {
        return injury;
    }

    public void setInjury(boolean injury) {
        this.injury = injury;
    }

    @Override
    public String toString() {
        return "PlayerPresentation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position=" + position +
                ", price=" + price +
                ", injury=" + injury +
                '}';
    }
}
