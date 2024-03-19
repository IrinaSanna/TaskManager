package ru.netology;

import java.util.Arrays;

public class Epic extends Task {
    protected int id;
    private String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String subtask : subtasks) {
            if (subtask.contains(query)) {
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public String[] getSubtasks() {
        return subtasks;
    }
}