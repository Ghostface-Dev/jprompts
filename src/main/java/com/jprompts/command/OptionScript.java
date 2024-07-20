package com.jprompts.command;

import com.jprompts.exceptions.InvalidResponseException;
import com.jprompts.request.Script;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;
import java.util.Objects;

final class OptionScript implements Script {

    private @Nullable String anwser;
    private final @NotNull Prompt prompt;

    public OptionScript(@NotNull Prompt prompt) {
        this.anwser = null;
        this.prompt = prompt;
    }

    @Override
    public @NotNull String response() {
        return Script.super.response();
    }

    @Override
    public boolean checkers(@NotNull String anwser) {
        try {
            if (Integer.parseInt(anwser) > 0 && Integer.parseInt(anwser) <= prompt.getQuestionList().size()) {
                return true;
            }
        } catch (RuntimeException e) {
            throw new InvalidResponseException("the answer goes beyond the meaning of the questions");
        }
        return false;
    }

    @Override
    public @Nullable String getAnwser() {
        return anwser;
    }

    @Override
    public void outDesignScript(@NotNull Prompt prompt) {
        int i = 1;
        for (@NotNull String question : prompt.getQuestionList()) {
            System.out.println(i + " - " + question);
            i++;
        }
    }

    @Override
    public void execute() {
        System.out.println();
        outDesignScript(prompt);
        anwser = response();
        while (!checkers(anwser)) {
            System.out.printf("You need to choose between %d and %d. %n", 1, prompt.getQuestionList().size());
            outDesignScript(prompt);
            anwser = response();
        }
    }

    @Override
    public @Nullable LinkedList<@NotNull String> getAnwsers() {
        return null;
    }

    // objects


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OptionScript that = (OptionScript) o;
        return Objects.equals(anwser, that.anwser) && Objects.equals(prompt, that.prompt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anwser, prompt);
    }
}
