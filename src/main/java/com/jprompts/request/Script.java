package com.jprompts.request;

import com.jprompts.command.Prompt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;

public interface Script extends RequestUser {

    boolean checkers(@NotNull String anwser);

    void outDesignScript(@NotNull Prompt prompt);

    void execute();

    @Nullable LinkedList<@NotNull String> getAnwsers();

    @Nullable String getAnwser();
}
