package com.svecw.mindquest;

public class QuestionAnswer {

    public static String[] question = {
            "Which of the following is a valid declaration of a char?",
            "Which of the following is a feature of Java?",
            "Which of the following is used to handle exceptions in Java?",
            "In Java, which keyword is used to create a subclass?",
            "What is the size of int in Java?",
            "Which of the following is not a Java keyword?",
            "Which of the following is used to terminate a loop in Java?",
            "Which method is used to start a thread in Java?",
            "What is the default value of a boolean variable in Java?",
            "What does JVM stand for in Java?"
    };

    public static String[][] choices = {
            {"char ch = 'g';", "char ch = \"g\";", "char ch = g;", "char ch = 100;"},
            {"Platform-dependent", "Compiled and interpreted", "Uses pointers", "Supports multiple inheritance"},
            {"try-catch", "catch-throw", "throw-catch", "try-final"},
            {"super", "extends", "implements", "inherits"},
            {"2 bytes", "4 bytes", "8 bytes", "16 bytes"},
            {"class", "try", "goto", "switch"},
            {"continue", "exit", "break", "return"},
            {"run()", "start()", "execute()", "init()"},
            {"true", "false", "0", "null"},
            {"A) Java Variable Machine", "B) Java Virtual Machine", "C) Java Verified Machine", "D) Java Version Machine"}
    };

    public static String[] correctAnswers = {
            "char ch = 'g';",
            "Compiled and interpreted",
            "try-catch",
            "extends",
            "4 bytes",
            "goto",
            "break",
            "start()",
            "false",
            "B) Java Virtual Machine"
    };
}
