package com.jprompts.script;

import com.jprompts.core.Prompt;
import com.jprompts.response.Input;
import com.jprompts.response.Script;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;

public class ListScript implements Script {
    private final @NotNull Prompt prompt;
    private final @NotNull Input input;
    private @Nullable String anwser;

    public ListScript(@NotNull Prompt prompt) {
        this.prompt = prompt;
        this.input = new Input(prompt);
    }

    @Override
    public void execute(Prompt prompt) {
        System.out.println();
        outDesignPrompt(prompt.getQuestions());
        this.anwser = getInput().getResponse();
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
            i++;
        }
    }

    @Override
    public @Nullable String getAnwser() {
        return this.anwser;
    }

    @Override
    public @NotNull Input getInput() {
        return this.input;
    }
}
