package com.jprompts.core.menu;

import com.jprompts.core.Prompt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;

public class MenuPrompt implements Prompt {
    private final @NotNull MenuScript script = new MenuScript();
    private final @NotNull LinkedList<@NotNull String> prompts = new LinkedList<>();
    private @NotNull String anwser;

    public MenuPrompt() {
        prompts.addLast("exit");
    }

    @Override
    public @Nullable String getAnwser(@NotNull Integer id) {
        anwser = script.getAnwser(id);
        return anwser;
    }

    @Override
    public void addQuestion(@NotNull String question, int id) {
        prompts.add(question);
        script.getPromptMap().put(id, null);
    }

    @Override
    public void run() {
        if (prompts.isEmpty()) {
            throw new RuntimeException("Questions not found");
        }

        script.execute();
        while (script.checkers()) {
            System.out.printf("You need to choose between 1 and %d%n", prompts.size());
            script.execute();
        }
    }

    @NotNull LinkedList<@NotNull String> getPrompts() {
        return prompts;
    }

}
