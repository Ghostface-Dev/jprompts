package com.jprompts.template;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;

public interface Prompt {

    void run();

    void addQuestion(@NotNull String question, @NotNull Integer ID);

    @Nullable String getAnwser(@NotNull Integer id);


}
