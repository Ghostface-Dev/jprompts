package com.jprompts.command;

import com.jprompts.request.Script;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;

final class ListScript implements Script {
    private final @NotNull LinkedHashMap<@NotNull String, @Nullable String> questionsMap = new LinkedHashMap <>();
    private @Nullable String anwser;

    @Override
    public boolean checkers() {
        return Integer.parseInt(anwser) > 0 && Integer.parseInt(anwser) <= questionsMap.size();
    }

    @Override
    public void execute() {
        int i = 1;
        for (@NotNull String key: questionsMap.keySet()) {
            System.out.println(i + " - " + key.toLowerCase());
            i++;
        }
        anwser = response();
        for (@NotNull String key : questionsMap.keySet()) {
            questionsMap.replace(key, null, anwser);
        }
    }

    @Override
    public @NotNull LinkedHashMap<@NotNull String, @Nullable String> getQuestionsMap() {
        return questionsMap;
    }

    @Override
    public @Nullable String getAnwser(@Nullable String question) {
        if (question == null) {
            return anwser;
        }
        return questionsMap.get(question);
    }

}
