package com.jprompts.command;

import com.jprompts.request.Script;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;

final class ConfirmScript implements Script {
    private final @NotNull LinkedHashMap<@NotNull String, @Nullable String> questionsMap = new LinkedHashMap<>();

    @Override
    public boolean checkers() {
        for (String value : questionsMap.values()) {
            if (!value.equalsIgnoreCase("y") && !value.equalsIgnoreCase("n")) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void execute() {
        for (@NotNull String key : questionsMap.keySet()) {
            System.out.println(" - " + key.toLowerCase() + " (y/n)");
            questionsMap.replace(key, null, response().toLowerCase());
        }
    }

    @Override
    public @NotNull LinkedHashMap<@NotNull String, @Nullable String> getQuestionsMap() {
        return this.questionsMap;
    }

    @Override
        public @Nullable String getAnwser(@Nullable String question) {
        return questionsMap.get(question);
    }
}
