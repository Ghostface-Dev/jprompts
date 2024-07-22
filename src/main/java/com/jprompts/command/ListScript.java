package com.jprompts.command;

import com.jprompts.request.Script;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;

final class ListScript implements Script {
    private final @NotNull LinkedHashMap<@NotNull String, @NotNull String> questionsMap = new LinkedHashMap <>();
    private @NotNull String anwser;

    public ListScript() {
    }

    @Override
    public boolean checkers() {
        return Integer.parseInt(this.anwser) > 0 && Integer.parseInt(this.anwser) <= questionsMap.size();
    }

    @Override
    public void execute() {
        int i = 1;
        for (@NotNull String key: questionsMap.keySet()) {
            System.out.println(i + " - " + key.toLowerCase());
            i++;
        }
        this.anwser = response();
        for (@NotNull String key : questionsMap.keySet()) {
            questionsMap.replace(key, "", this.anwser);
        }
    }

    @Override
    public @NotNull LinkedHashMap<@NotNull String, @Nullable String> getQuestionsMap() {
        return this.questionsMap;
    }

    @Override
    public @NotNull String getAnwser(@Nullable String question) {
        if (question == null) {
            return this.anwser;
        }
        return questionsMap.get(question);
    }

}
