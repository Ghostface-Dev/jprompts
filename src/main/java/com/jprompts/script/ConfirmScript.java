package com.jprompts.script;

import com.jprompts.core.Prompt;
import com.jprompts.exception.InconsistentScriptException;
import com.jprompts.response.Input;
import com.jprompts.response.Script;
import org.jetbrains.annotations.NotNull;


import java.util.LinkedList;

public class ConfirmScript implements Script {
    private final @NotNull Prompt prompt;
    private final @NotNull Input input;
    private @NotNull String answer;

    public ConfirmScript(@NotNull Prompt prompt) {
        this.prompt = prompt;
        this.input = new Input(prompt);
        if (!prompt.getType().equalsIgnoreCase("confirm")) {
            throw new InconsistentScriptException("The script type and prompt type parameter must be consistent");
        }
    }

    @Override
    public void execute(Prompt prompt) {
        System.out.println();
        outDesignPrompt(prompt.getQuestions());
        this.answer = getInput().getResponse();
    }

    @Override
    public @NotNull Prompt getPrompt() {
        return prompt;
    }

    @Override
    public void outDesignPrompt(@NotNull LinkedList<@NotNull String> prompts) {
        System.out.println("- " + prompts.getFirst() + " (y/n) ");
    }


    public @NotNull String getAnwser() {
        return this.answer;
    }


    @Override
    public @NotNull Input getInput() {
        return this.input;
    }
}
