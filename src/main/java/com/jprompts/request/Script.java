package com.jprompts.request;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;

public interface Script extends RequestUser {

    boolean checkers();

    void execute();

    @NotNull LinkedHashMap<@NotNull Integer, @Nullable String> getPromptMap();

    @Nullable String getAnwser(@NotNull Integer id);
}
