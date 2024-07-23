package com.jprompts.command;

import com.jprompts.request.Script;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;

final class InputScript implements Script {
    private final @NotNull LinkedHashMap<@NotNull String, @Nullable String> questionsMap = new LinkedHashMap<>();

    @Override
    public boolean checkers() {
        return true;
    }

    @Override
    public void execute() {
        for (@NotNull String key : questionsMap.keySet()) {
            System.out.print(" - " + key + ": ");
            questionsMap.replace(key, null, response().toLowerCase());
        }
    }

    @Override
    public @NotNull LinkedHashMap<@NotNull String, @Nullable String> getQuestionsMap() {
        return questionsMap;
    }

    @Override
    public @Nullable String getAnwser(@NotNull String question) {
        return questionsMap.get(question);
    }
}
