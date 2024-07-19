package com.jprompts.script;

import com.jprompts.core.Prompt;
import com.jprompts.response.Input;
import com.jprompts.response.Script;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class ConfirmScript implements Script {
    private final @NotNull Prompt prompt;
    private final @NotNull Input input;

    public ConfirmScript(@NotNull Prompt prompt) {
        this.prompt = prompt;
        this.input = new Input( prompt);
    }

    @Override
    public void execute() {

    }

    @Override
    public @NotNull Prompt getPrompt() {
        return prompt;
    }

    @Override
    public void outDesignPrompt(@NotNull LinkedList<@NotNull String> prompts) {
        System.out.println("- " + prompts.getFirst() + " (y/n) ");
    }

    @Override
    public @NotNull String getResponse() {
        return input.getResponse();
    }
}
