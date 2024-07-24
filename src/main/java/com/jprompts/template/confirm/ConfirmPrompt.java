package com.jprompts.template.confirm;

import com.jprompts.template.Prompt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;

public final class ConfirmPrompt implements Prompt {
    private final @NotNull ConfirmScript script = new ConfirmScript(this);
    private final @NotNull LinkedHashMap<@NotNull Integer, @NotNull String> prompts = new LinkedHashMap<>();
    private @Nullable String anwser;

    @Override
    public void run() {
        script.executeTemplate();
        while (!script.checkers()) {
            System.out.println("Invalid command present. You just need to chose between Y or N.");
            script.executeTemplate();
        }
    }

    @Override
    public void addQuestion(@NotNull String question, @NotNull Integer ID) {
        prompts.put(ID, question);
        script.getAnwsers().put(ID, null);
    }

    @Override
    public @Nullable String getAnwser(@NotNull Integer id) {
        return anwser = script.getAnwser(id);
    }

    @NotNull LinkedHashMap<@NotNull Integer, @NotNull String> getPrompts() {
        return prompts;
    }
}
