package com.jprompts.core.input;

import com.jprompts.request.Script;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;

final class InputScript implements Script {
    private final @NotNull InputPrompt prompt;
    private final @NotNull LinkedHashMap<@NotNull Integer, @Nullable String> promptsMap = new LinkedHashMap<>();

    public InputScript(@NotNull InputPrompt prompt) {
        this.prompt = prompt;
    }

    @Override
    public boolean checkers() {
        return false;
    }

    @Override
    public void execute() {
        for (@NotNull String prompt : prompt.getPrompts()) {
            System.out.print(" - " + prompt + ": ");
            for (@NotNull Integer id : promptsMap.keySet()) {
                promptsMap.replace(id, null, response().toLowerCase());
            }
        }
    }

    @Override
    public @NotNull LinkedHashMap<@NotNull Integer, @Nullable String> getPromptMap() {
        return promptsMap;
    }

    @Override
    public @Nullable String getAnwser(@NotNull Integer id) {
        return promptsMap.get(id);
    }
}
