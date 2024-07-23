package com.jprompts.core;

import com.jprompts.request.Script;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.LinkedList;


public interface Prompt {

    @Nullable String getAnwser(@NotNull Integer id);

    void addQuestion(@NotNull String question, int id);

    void run();

}

