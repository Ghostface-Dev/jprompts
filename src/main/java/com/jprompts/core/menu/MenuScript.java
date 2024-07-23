package com.jprompts.core.menu;

import com.jprompts.core.Prompt;
import com.jprompts.request.Script;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;

final class MenuScript implements Script {
    private final @NotNull LinkedHashMap<@NotNull Integer, @Nullable String> promptsMap = new LinkedHashMap<>();
    private final @NotNull MenuPrompt prompt;
    private @NotNull String anwser;

    public MenuScript(@NotNull MenuPrompt prompt) {
        this.prompt = prompt;
    }

    @Override
    public boolean checkers() {
        return Integer.parseInt(anwser) > 0 && Integer.parseInt(anwser) <= prompt.getPrompts().size();
    }

    @Override
    public void execute() {
        int i = 1;
        for (@NotNull String prompts : prompt.getPrompts()) {
            System.out.println(i + " - " + prompts);
            i++;
        }
        anwser = response();
        prompt.setAnwser(anwser);
        promptsMap.replaceAll((id, response) -> anwser);
    }

    @Override
    public @NotNull LinkedHashMap<Integer, @Nullable String> getPromptMap() {
        return promptsMap;
    }

    @Override
    public @Nullable String getAnwser(@NotNull Integer id) {
        return promptsMap.get(id);
    }


}