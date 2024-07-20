package com.jprompts.request;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.Scanner;

interface RequestUser {

    // static initializer

    default @NotNull String response() {
        @NotNull Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        return String.valueOf(sc.nextLine());
    }

}
