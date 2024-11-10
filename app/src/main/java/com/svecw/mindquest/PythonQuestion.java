package com.svecw.mindquest;

public class PythonQuestion {
    public static String[] question = {
            "What is the size of an integer in Python?",
            "Which of the following is a valid way to declare a string in Python?",
            "What keyword is used to define a function in Python?",
            "Which method is used to compare two strings in Python?",
            "What is the default value of a variable in Python?",
            "Which of the following data types can hold a decimal value in Python?",
            "What is the purpose of the 'def' keyword in Python?",
            "Which collection type is used to store key-value pairs in Python?",
            "What does the 'lambda' keyword signify in Python?",
            "What is the main entry point of a Python script?"
    };

    public static String[][] choices = {
            {"1 byte", "2 bytes", "4 bytes", "Python does not have a fixed size"},
            {"string str = 'hello'", "str = 'hello'", "str = \"hello\"", "s = hello"},
            {"define", "function", "def", "func"},
            {"compare()", "equals()", "==", "match()"},
            {"0", "null", "None", "1"},
            {"float", "double", "int", "None"},
            {"It defines a variable", "It defines a function", "It creates a class", "It initializes variables"},
            {"dict", "list", "set", "tuple"},
            {"It creates an anonymous function", "It creates a variable", "It defines a class", "It declares a loop"},
            {"if __name__ == '__main__':", "def main():", "if main:", "start()"}
    };

    public static String[] correctAnswers = {
            "Python does not have a fixed size",
            "str = 'hello'",
            "def",
            "==",
            "None",
            "float",
            "It defines a function",
            "dict",
            "It creates an anonymous function",
            "if __name__ == '__main__':"
    };
}

