package com.jprompts.template.input;

import com.jprompts.Script;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

final class InputScript implements Script {
    private final @NotNull InputPrompt prompt;
    private final @NotNull LinkedHashMap<@NotNull Integer, @Nullable String> anwsers = new LinkedHashMap<>();

    public InputScript(@NotNull InputPrompt prompt) {
        this.prompt = prompt;
    }

    @Override
    public void executeTemplate() {
        for (Map.Entry<@NotNull Integer, @NotNull String> prompts : prompt.getPrompts().entrySet()) {
            System.out.print(" - " + prompts.getValue() + ": ");
            anwsers.replace(prompts.getKey(), null, getResponse());
        }
    }

    @Override
    public @Nullable String getAnwser(@NotNull Integer id) {
        return anwsers.get(id);
    }

    @Override
    public boolean checkers() {
        for (Map.Entry<@NotNull Integer, @Nullable String> id: anwsers.entrySet()) {
            if (id == null) {
                throw new NullPointerException("Anwser is not defined");
            }
            if (id.getValue().length() > 30 || id.getValue().isEmpty()) {
                throw new IllegalArgumentException("String must be between 1 and 30 caractere");
            }
        }
        return true;
    }

    @Override
    public @NotNull LinkedHashMap<@NotNull Integer, @Nullable String> getAnwsers() {
        return anwsers;
    }


}
