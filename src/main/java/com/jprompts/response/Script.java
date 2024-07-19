package com.jprompts.response;


import com.jprompts.core.Prompt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;

public interface Script {

    /*
    * executa e retorna a saida
    * */
    void execute(Prompt prompt);

    /*
    * Posso usar o prompt vinculado a ele
    * */
    @NotNull Prompt getPrompt();

    /*
    * Como o design do script opera com o prompt
    * */
    void outDesignPrompt(@NotNull LinkedList<@NotNull String> prompts);

    /*
    * Retorna a resposta do usuario
    * */

    @NotNull Input getInput();
}
