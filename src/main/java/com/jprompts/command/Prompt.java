package com.jprompts.command;

import com.jprompts.request.Script;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class Prompt {

    private final @NotNull LinkedList<@NotNull String> questionList = new LinkedList<>();
    private final @NotNull Map<@NotNull String, @Nullable String> questionMap = new HashMap<>();
    private @Nullable String answer;
    private final @NotNull Script script;

    public Prompt(@NotNull String type) {
        if (type.equalsIgnoreCase("list")) {
            this.script = new OptionScript(this);
        } else if (type.equalsIgnoreCase("confirm")) {
            this.script = new ConfirmScript(this);
        } else {
            throw new RuntimeException("Invalid script type");
        }
    }

    public void addQuestion(@NotNull String message) {
        if (this.script.equals(new OptionScript(this))) {
            questionList.add(message);
        }
        if (this.script.equals(new ConfirmScript(this))) {
            questionMap.put(message, null);
        }
    }

    public void run() {
        this.script.execute();
    }

    public @Nullable String anwser(@Nullable String question) {
        return  question;
    }

    @NotNull LinkedList<@NotNull String> getQuestionList() {
        return questionList;
    }

    @NotNull Map<@NotNull String, @Nullable String> getQuestionMap() {
        return questionMap;
    }

}
