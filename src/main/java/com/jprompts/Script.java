package com.jprompts;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Scanner;


public interface Script extends RequestUser {

    @NotNull LinkedHashMap<@NotNull Integer, @Nullable String> getAnwsers();

    void executeTemplate();

    @Nullable String getAnwser(@NotNull Integer id);

    boolean checkers();
}

interface RequestUser {

    default @NotNull String getResponse() {
        @NotNull Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        return String.valueOf(sc.nextLine());
    }

}
