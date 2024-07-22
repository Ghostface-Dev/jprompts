package com.jprompts.request;

import com.jprompts.command.Prompt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public interface Script extends RequestUser {

    boolean checkers();

    void execute();

    @NotNull LinkedHashMap<@NotNull String, @Nullable String> getQuestionsMap();

    @NotNull String getAnwser(@NotNull String question);
}
