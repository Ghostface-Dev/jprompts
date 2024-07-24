package com.jprompts.template.list;

import com.jprompts.Script;
import com.jprompts.template.Prompt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;

public class ListPrompt implements Prompt {
    private final @NotNull ListScript script = new ListScript(this);
    private final @NotNull LinkedHashMap<@NotNull Integer, @NotNull String> prompts = new LinkedHashMap<>();
    private @Nullable String anwser;

    @Override
    public void run() {
        script.executeTemplate();
        while (!script.checkers()) {
            System.out.printf("You need to choose between 1 and %d%n", script.getAnwsers().entrySet().size());
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
