package com.jprompts.template.input;

import com.jprompts.Script;
import com.jprompts.template.Prompt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;

public final class InputPrompt implements Prompt {
    private final @NotNull InputScript script = new InputScript(this);
    private final @NotNull LinkedHashMap<@NotNull Integer, @NotNull String> prompts = new LinkedHashMap<>();
    private @Nullable String anwser;

    @Override
    public void run() {
        script.executeTemplate();
        script.checkers();
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
