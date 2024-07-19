package com.jprompts.script;

import com.jprompts.core.Prompt;
import com.jprompts.response.Script;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class ListScript implements Script {
    private final @NotNull Prompt prompt;

    public ListScript(@NotNull Prompt prompt) {
        this.prompt = prompt;
    }

    @Override
    public void execute() {
        System.out.println();
    }

    @Override
    public @NotNull Prompt getPrompt() {
        return this.prompt;
    }


    @Override
    public void outDesignPrompt(@NotNull LinkedList<@NotNull String> prompts) {
        int i = 1;
        for (@NotNull String question: prompts) {
            System.out.println(i + " - " + question);
        }
    }

    @Override
    public @NotNull String getResponse() {
        return "";
    }
}
