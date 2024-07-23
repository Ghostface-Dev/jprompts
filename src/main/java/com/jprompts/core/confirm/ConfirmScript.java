package com.jprompts.core.confirm;

import com.jprompts.request.Script;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;

final class ConfirmScript implements Script {
    private final @NotNull LinkedHashMap<@NotNull Integer, @Nullable String> promptsMap = new LinkedHashMap<>();
    private final @NotNull ConfirmPrompt prompt;

    public ConfirmScript(@NotNull ConfirmPrompt prompt) {
        this.prompt = prompt;
    }

    @Override
    public boolean checkers() {
        for (String value : promptsMap.values()) {
            if (!value.equalsIgnoreCase("y") && !value.equalsIgnoreCase("n")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void execute() {
        for (@NotNull String prompts : prompt.getPrompts()) {
            System.out.println(" - " + prompts + " (y/n)");
            for (Integer id : promptsMap.keySet()) {
                promptsMap.replace(id, null, response());
            }
        }
    }

    @Override
    public @NotNull LinkedHashMap<Integer, @Nullable String> getPromptMap() {
        return this.promptsMap;
    }

    @Override
        public @Nullable String getAnwser(@NotNull Integer id) {
        return promptsMap.get(id);
    }

}
