package com.jprompts.response;

import com.jprompts.core.Prompt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;
import java.util.Scanner;

public class Input {
    private final @NotNull Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    private @NotNull String response;
    private final Prompt prompt;
    private @Nullable String anwser;

    public Input(@NotNull Prompt prompt, @NotNull String anwser) {
        this.prompt = prompt;
        this.anwser = anwser;
    }

    public Input(@NotNull Prompt prompt) {
        this.prompt = prompt;
        this.anwser = null;
    }

    public boolean checkers() {
        if (anwser != null) {
            @NotNull String anwser = this.anwser;
            return anwser.equalsIgnoreCase(this.anwser);
        }
        if (prompt.getType().equalsIgnoreCase("list")) {
            return Integer.parseInt(response) > 0 && Integer.parseInt(response) < prompt.getQuestions().size();
        }
        if (prompt.getType().equalsIgnoreCase("confirm")) {
            return response.equalsIgnoreCase("y") || response.equalsIgnoreCase("n");
        }

        return false;
    }

    public @NotNull String getResponse() {
        return response = sc.nextLine();
    }

}
