package com.jprompts.core.confirm;

import com.jprompts.core.Prompt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;

public class ConfirmPrompt implements Prompt {
    private final @NotNull ConfirmScript script = new ConfirmScript(this);
    private final @NotNull LinkedList<@NotNull String> prompts = new LinkedList<>();
    private @NotNull String anwser;

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
        script.execute();
        while (script.checkers()) {
            System.out.println("You need to choose Y or N");
            script.execute();
        }
    }

    @NotNull LinkedList<@NotNull String> getPrompts() {
        return prompts;
    }
}
