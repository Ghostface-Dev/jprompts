package com.jprompts.core.menu;

import com.jprompts.request.Script;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;

final class MenuScript implements Script {
    private final @NotNull LinkedHashMap<@NotNull Integer, @Nullable String> promptsMap = new LinkedHashMap<>();
    private final @NotNull MenuPrompt prompt = new MenuPrompt();
    private @NotNull String anwser;
    private final @NotNull String exit = String.valueOf(prompt.getPrompts().size());
    // while anwser != size

    @Override
    public boolean checkers() {
        return Integer.parseInt(anwser) <= 0 || Integer.parseInt(anwser) > prompt.getPrompts().size();
    }

    @Override
    public void execute() {
        while (!anwser.equals(exit)) {
            int i = 1;
            for (@NotNull String prompts : prompt.getPrompts()) {
                System.out.println(i + " - " + prompts);
                i++;
            }
            anwser = response();
            promptsMap.replaceAll((id, response) -> anwser);
        }
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