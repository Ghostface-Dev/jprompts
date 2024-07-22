package com.jprompts.command;

import com.jprompts.exceptions.InvalidResponseException;
import com.jprompts.request.Script;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Prompt {
    private final @NotNull Script script;
    private @Nullable String anwser;

    private final boolean isList;
    private final boolean isConfirm;

    public Prompt(@NotNull String type) {
        if (type.equalsIgnoreCase("list")) {
            this.script = new ListScript();
        }else if (type.equalsIgnoreCase("confirm")) {
            this.script = new ConfirmScript();
        }else {
            throw new IllegalArgumentException("This prompt type not exist");
        }
        this.isList = script instanceof ListScript;
        this.isConfirm = script instanceof ConfirmScript;
    }

    public void addQuestion(@NotNull String question) {
        if (isList) {
            this.script.getQuestionsMap().put(question, null);
        }
        if (isConfirm) {
            this.script.getQuestionsMap().putFirst(question, null);
        }
    }

    public @Nullable String anwser(@Nullable String question) {
        if (isList) {
            return this.script.getAnwser(question);
        }
        if (isConfirm) {
            return this.script.getAnwser(question);
        }
        return this.anwser;
    }

    public void run() {
        if (script.getQuestionsMap().isEmpty()) {
            throw new RuntimeException("Prompt has no questions");
        }
        if (isList) {
            this.script.execute();
            while (!this.script.checkers()) {
                System.out.printf("Invalid command, you need to choose between 1 and %d%n", this.script.getQuestionsMap().size());
                this.script.execute();
            }
        }
        if (isConfirm) {
            this.script.execute();
            if (!this.script.checkers()) {
                throw new InvalidResponseException("some response is not valid.");
            }
        }
    }
}
