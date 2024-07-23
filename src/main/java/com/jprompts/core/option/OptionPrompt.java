package com.jprompts.core.option;

import com.jprompts.core.Prompt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;

public class OptionPrompt implements Prompt {
    private final @NotNull OptionScript script = new OptionScript();
    private final @NotNull LinkedList<@NotNull String> prompts = new LinkedList<>();
    private @NotNull String anwser;

    @Override
    public @Nullable String getAnwser(@NotNull Integer id) {
        if (id == 0) {
            return script.getAnwser(1);
        }
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
        while (!script.checkers()) {
            System.out.printf("You need to choose between 1 and %d%n", prompts.size());
        }
    }

    @NotNull LinkedList<@NotNull String> getPrompts() {
        return prompts;
    }
}
