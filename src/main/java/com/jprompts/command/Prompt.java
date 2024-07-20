package com.jprompts.command;

import com.jprompts.exceptions.*;
import com.jprompts.request.Script;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public final class Prompt {

    private final @NotNull LinkedList<@NotNull String> questionList = new LinkedList<>();
    private final @NotNull Map<@NotNull String, @Nullable String> questionMap = new LinkedHashMap<>();
    private final @NotNull Script script;
    // instanceOf
    private final boolean isOption;
    private final boolean isConfirm;

    public Prompt(@NotNull String type) {
        if (type.equalsIgnoreCase("list")) {
            this.script = new OptionScript(this);
        } else if (type.equalsIgnoreCase("confirm")) {
            this.script = new ConfirmScript(this);
        } else {
            throw new RuntimeException("Invalid script type");
        }
        isOption = script instanceof OptionScript;
        isConfirm = script instanceof ConfirmScript;
    }

    public void addQuestion(@NotNull String message) {
        if (isOption) {
            questionList.add(message.toLowerCase());
        }
        if (isConfirm) {
            questionMap.put(message.toLowerCase(), null);
        }
    }

    public void run() {
        this.script.execute();
    }

    public @Nullable String anwser(@Nullable String question) {
        // if is a option type
        if (isOption) {
            for (@NotNull String msg : questionList) {
                if (msg.equalsIgnoreCase(question) || question == null) {
                    return script.getAnwser();
                }
            }
        }
        if (isConfirm) {
            if (questionMap.containsKey(question)) {
                return questionMap.get(question);
            }
        }

        return null;
    }

    public @Nullable String answerIfOption() {
        @NotNull OptionScript option = new OptionScript(this);
        if (!isOption) {
            throw new NotEqualsScriptTypeException("Type is not a 'List', try using the getAnswer method");
        }
        return anwser(null);
    }

    @NotNull LinkedList<@NotNull String> getQuestionList() {
        return questionList;
    }

    @NotNull Map<@NotNull String, @Nullable String> getQuestionMap() {
        return questionMap;
    }

    // objects

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prompt prompt = (Prompt) o;
        return Objects.equals(questionList, prompt.questionList) && Objects.equals(questionMap, prompt.questionMap) && Objects.equals(script, prompt.script);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionList, questionMap, script);
    }
}
