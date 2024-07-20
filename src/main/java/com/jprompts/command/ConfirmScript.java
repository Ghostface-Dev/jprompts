package com.jprompts.command;

import com.jprompts.request.Script;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;
import java.util.Objects;

final class ConfirmScript implements Script {

    private final @NotNull Prompt prompt;

    ConfirmScript(@NotNull Prompt prompt) {
        this.prompt = prompt;
    }


    @Override
    public boolean checkers(@NotNull String anwser) {
        return false;
    }

    @Override
    public void outDesignScript(@NotNull Prompt prompt) {
        for (@NotNull String key : prompt.getQuestionMap().keySet()) {
            System.out.println(" - " + key.toUpperCase() + " (y/n)");
            prompt.getQuestionMap().replace(key, null, response().toLowerCase());
        }
    }

    @Override
    public void execute() {
        System.out.println();
        outDesignScript(prompt);
    }

    @Override
    public @NotNull LinkedList<@NotNull String> getAnwsers() {
        return null;
    }

    @Override
    public @Nullable String getAnwser() {
        return null;
    }

    // objects
    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfirmScript that = (ConfirmScript) o;
        return Objects.equals(prompt, that.prompt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(prompt);
    }
}
