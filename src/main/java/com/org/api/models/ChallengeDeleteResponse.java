package com.org.api.models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ChallengeDeleteResponse {
        private int id;
        private String name;
        private ArrayList<TasksChallenge> tasks;
}
