package com.jprompts.core;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class Prompt {
    private final @NotNull LinkedList<@NotNull String> questions = new LinkedList<>();
    private final @NotNull String type;

    public Prompt(@NotNull String type) {
        this.type = type;
    }

    public final void addQuestion(@NotNull String question) {
        if (type.equalsIgnoreCase("list")) {
            questions.add(question);
        }
        if (type.equalsIgnoreCase("confirm")) {
            questions.addFirst(question);
        }
        if (type.equalsIgnoreCase("input")) {
            questions.add(question);
        }
    }

    public @NotNull String getType() {
        return type;
    }

    public @NotNull LinkedList<@NotNull String> getQuestions() {
        return questions;
    }
}
