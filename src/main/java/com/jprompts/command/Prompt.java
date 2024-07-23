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
    private final boolean isInput;

    public Prompt(@NotNull String type) {
        if (type.equalsIgnoreCase("list")) {
            script = new ListScript();
        } else if (type.equalsIgnoreCase("confirm")) {
            script = new ConfirmScript();
        } else if (type.equalsIgnoreCase("input")) {
            script = new InputScript();
        } else {
            throw new IllegalArgumentException("This prompt type not exist");
        }

        isList = script instanceof ListScript;
        isConfirm = script instanceof ConfirmScript;
        isInput = script instanceof InputScript;
    }

    public void addQuestion(@NotNull String question) {
        if (!isConfirm) {
            script.getQuestionsMap().put(question, null);
        }
        if (isConfirm) {
            script.getQuestionsMap().putFirst(question, null);
        }
    }

    public @Nullable String anwser(@Nullable String question) {
        return script.getAnwser(question);
    }

    public void run() {
        if (script.getQuestionsMap().isEmpty()) {
            throw new RuntimeException("Prompt has no questions");
        }
        if (isList) {
            script.execute();
            while (!script.checkers()) {
                System.out.printf("Invalid command, you need to choose between 1 and %d%n", script.getQuestionsMap().size());
                script.execute();
            }
        }
        if (isConfirm) {
            script.execute();
            if (!script.checkers()) {
                throw new InvalidResponseException("some response is not valid.");
            }
        }
        if (isInput) {
            script.execute();
        }
    }
}
