package ru.nxthing.mathgraph;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.nxthing.mathgraph.command.CommandRegistry;
import ru.nxthing.mathgraph.graph.MathGraph;
import ru.nxthing.mathgraph.utils.ParsedCommand;

import java.util.Scanner;

@SpringBootApplication
@AllArgsConstructor
public class MathGraphApplication implements CommandLineRunner {
    private final CommandRegistry commandRegistry;
    private final MathGraph graph;
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(MathGraphApplication.class, args);
    }

    @Override
    public void run(String... args) {
        ParsedCommand command;

        while (true) {
            command = ParsedCommand.parse(scanner.nextLine());
            try {
                commandRegistry.execute(command.getCommandName(), command.getParameters(), graph);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
