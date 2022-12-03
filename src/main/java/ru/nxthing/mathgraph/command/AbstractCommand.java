package ru.nxthing.mathgraph.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class AbstractCommand {
    private final String name;
    private final String signature;
    private final String description;
}