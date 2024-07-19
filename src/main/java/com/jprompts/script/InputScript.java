package com.jprompts.script;

import com.jprompts.core.Prompt;
import com.jprompts.response.Input;
import com.jprompts.response.Script;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class InputScript implements Script {
    private final @NotNull Prompt prompt;
    private final @NotNull Input input;

    public InputScript(@NotNull Prompt prompt) {
        this.prompt = prompt;
        this.input = new Input(prompt);
    }

    @Override
    public void execute(Prompt prompt) {

    }

    @Override
    public @NotNull Prompt getPrompt() {
        return null;
    }

    @Override
    public void outDesignPrompt(@NotNull LinkedList<@NotNull String> prompts) {

    }

    @Override
    public @NotNull String getAnwser() {
        return "";
    }

    @Override
    public @NotNull Input getInput() {
        return null;
    }
}
