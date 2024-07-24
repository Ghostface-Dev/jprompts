package com.jprompts.template.list;

import com.jprompts.Script;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

public class ListScript implements Script {
    private final @NotNull ListPrompt prompt;
    private final @NotNull LinkedHashMap<@NotNull Integer, @Nullable String> anwsers = new LinkedHashMap<>();

    public ListScript(@NotNull ListPrompt prompt) {
        this.prompt = prompt;
    }

    @Override
    public @NotNull LinkedHashMap<@NotNull Integer, @Nullable String> getAnwsers() {
        return anwsers;
    }

    @Override
    public void executeTemplate() {
        int i = 1;
        for (Map.Entry<@NotNull Integer, @NotNull String> entry : prompt.getPrompts().entrySet()) {
            System.out.println(i + " - " + entry.getValue());
            i++;
        }
        @NotNull String anwser = getResponse();
        anwsers.replaceAll((id, value) -> anwser);
    }

    @Override
    public @Nullable String getAnwser(@NotNull Integer id) {
        return anwsers.get(id);
    }

    @Override
    public boolean checkers() {
        for (Map.Entry<@NotNull Integer, @Nullable String> entry : anwsers.entrySet()) {
            @Nullable String value = entry.getValue();
            if (Integer.parseInt(value) > 0 && Integer.parseInt(value) <= anwsers.entrySet().size()) {
                return true;
            }
        }
        return false;
    }
}
