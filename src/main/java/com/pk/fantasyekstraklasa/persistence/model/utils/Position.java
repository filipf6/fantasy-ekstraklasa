package com.pk.fantasyekstraklasa.persistence.model.utils;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Position {
        GOALKEEPER, DEFENDER, MIDFIELDER, FORWARD;

//        @JsonCreator
//        public static Position fromValue(String value) {
//               if(value.toUpperCase().equals("GOALKEEPER"))
//        }
}
