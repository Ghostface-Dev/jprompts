package com.jprompts.core.input;

import com.jprompts.core.Prompt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;

public class InputPrompt implements Prompt {
    private final @NotNull InputScript script = new InputScript(this);
    private final @NotNull LinkedList<@NotNull String> prompts = new LinkedList<>();
    private @NotNull String anwser;

    @Override
    public @Nullable String getAnwser(@NotNull Integer id) {
        return anwser = script.getAnwser(id);
    }

    @Override
    public void addQuestion(@NotNull String question, int id) {
        prompts.add(question);
        script.getPromptMap().put(id, null);
    }

    @Override
    public void run() {
        script.execute();
    }

    @NotNull LinkedList<@NotNull String> getPrompts() {
        return prompts;
    }
}
