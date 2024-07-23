package com.jprompts.core.option;

import com.jprompts.core.Prompt;
import com.jprompts.request.Script;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;

final class OptionScript implements Script {
    private final @NotNull OptionPrompt prompt;
    private final @NotNull LinkedHashMap<@NotNull Integer, @Nullable String> promptMap = new LinkedHashMap <>();
    private @NotNull String anwser;

    public OptionScript(@NotNull OptionPrompt prompt) {
        this.prompt = prompt;
    }

    @Override
    public boolean checkers() {
        return Integer.parseInt(anwser) <= 0 || Integer.parseInt(anwser) > promptMap.size();
    }

    @Override
    public void execute() {
        int i = 1;
        for (@NotNull String prompt: prompt.getPrompts()) {
            System.out.println(i + " - " + prompt.toLowerCase());
            i++;
        }
        anwser = response();
        promptMap.replaceAll((id, response) -> anwser);
    }

    @Override
    public @NotNull LinkedHashMap<@NotNull Integer, @Nullable String> getPromptMap() {
        return promptMap;
    }

    @Override
    public @Nullable String getAnwser(@Nullable Integer id) {
        return promptMap.get(id);
    }

}
