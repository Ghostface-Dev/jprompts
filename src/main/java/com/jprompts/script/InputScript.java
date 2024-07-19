package com.jprompts.script;

import com.jprompts.core.Prompt;
import com.jprompts.response.Script;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class InputScript implements Script {
    private final @NotNull Prompt prompt;

    public InputScript(@NotNull Prompt prompt) {
        this.prompt = prompt;
    }

    @Override
    public void execute() {

    }

    @Override
    public @NotNull Prompt getPrompt() {
        return null;
    }

    @Override
    public void outDesignPrompt(@NotNull LinkedList<@NotNull String> prompts) {

    }

    @Override
    public @NotNull String getResponse() {
        return "";
    }
}
