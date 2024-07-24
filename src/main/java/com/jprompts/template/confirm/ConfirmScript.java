package com.jprompts.template.confirm;

import com.jprompts.Script;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

final class ConfirmScript implements Script {
    private final @NotNull ConfirmPrompt prompt;
    private final @NotNull LinkedHashMap<@NotNull Integer, @Nullable String> anwers = new LinkedHashMap<>();

    public ConfirmScript(@NotNull ConfirmPrompt prompt) {
        this.prompt = prompt;
    }

    @Override
    public @NotNull LinkedHashMap<@NotNull Integer, @Nullable String> getAnwsers() {
        return anwers;
    }

    @Override
    public void executeTemplate() {
        for (Map.Entry<@NotNull Integer, @Nullable String> prompts: prompt.getPrompts().entrySet()) {
            System.out.print(" - " + prompts.getValue() + " (y/n) ");
            anwers.replace(prompts.getKey(), null, getResponse().toLowerCase());
        }
    }

    @Override
    public @Nullable String getAnwser(@NotNull Integer id) {
        return anwers.get(id);
    }

    @Override
    public boolean checkers() {
        for (Map.Entry<@NotNull Integer, @NotNull String> entry : anwers.entrySet()) {
            @Nullable String value = entry.getValue();
            if (!value.equalsIgnoreCase("y") && !value.equalsIgnoreCase("n")) {
                return false;
            }
        }
        return true;
    }
}
