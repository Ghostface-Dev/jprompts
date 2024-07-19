package com.jprompts.script;

import com.jprompts.core.Prompt;
import com.jprompts.exception.InconsistentScriptException;
import com.jprompts.exception.ResponseNoAllowed;
import com.jprompts.response.Input;
import com.jprompts.response.Script;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class InputScript implements Script {
    private final @NotNull Prompt prompt;
    private final @NotNull Input input;

    private final @NotNull Map<@NotNull String, @NotNull String> anwser = new HashMap<>();

    public InputScript(@NotNull Prompt prompt) {
        this.prompt = prompt;
        this.input = new Input(prompt);
        if (prompt.getType().equalsIgnoreCase("input")) {
            throw new InconsistentScriptException("The script type and prompt type parameter must be consistent");
        }
    }

    @Override
    public void execute(Prompt prompt) {
        outDesignPrompt(prompt.getQuestions());
    }

    @Override
    public @NotNull Prompt getPrompt() {
        return prompt;
    }

    @Override
    public void outDesignPrompt(@NotNull LinkedList<@NotNull String> prompts) {
        for (@NotNull String question : prompts) {
            System.out.printf("%s: %n", question);
            anwser.put(question, getInput().getResponse());
        }
    }

    public @NotNull String getAnwser(@NotNull String question) {
        try {
            return anwser.get(question);
        } catch (Exception e) {
            throw new ResponseNoAllowed("Anser not found");
        }
    }

    @Override
    public @NotNull Input getInput() {
        return input;
    }
}
