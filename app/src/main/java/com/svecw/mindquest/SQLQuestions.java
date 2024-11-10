package com.svecw.mindquest;

public class SQLQuestions {
    public static String[] question = {
            "What does SQL stand for?",
            "Which of the following is a valid SQL statement to retrieve data from a table?",
            "Which SQL keyword is used to filter records?",
            "What is the default sorting order of the ORDER BY clause in SQL?",
            "Which SQL statement is used to update data in a database?",
            "Which SQL function is used to count the number of rows?",
            "What is a primary key in SQL?",
            "Which SQL clause is used to group rows that have the same values?",
            "Which command is used to delete a table in SQL?",
            "What is the purpose of the JOIN clause in SQL?"
    };

    public static String[][] choices = {
            {"Structured Query Language", "Structured Question Language", "Simple Query Language", "None of the above"},
            {"SELECT * FROM table_name;", "GET FROM table_name;", "FETCH FROM table_name;", "RETRIEVE table_name;"},
            {"WHERE", "FILTER", "HAVING", "SELECT"},
            {"Ascending", "Descending", "Random", "None"},
            {"UPDATE table_name SET column_name = value;", "MODIFY table_name;", "CHANGE table_name;", "EDIT table_name;"},
            {"COUNT()", "SUM()", "TOTAL()", "ADD()"},
            {"A unique identifier for a record", "A foreign key reference", "An index on a table", "A column with NULL values"},
            {"GROUP BY", "ORDER BY", "HAVING", "DISTINCT"},
            {"DROP TABLE table_name;", "REMOVE TABLE table_name;", "DELETE TABLE table_name;", "CLEAR TABLE table_name;"},
            {"To combine rows from two or more tables", "To sort data", "To filter data", "To create a new table"}
    };

    public static String[] correctAnswers = {
            "Structured Query Language",
            "SELECT * FROM table_name;",
            "WHERE",
            "Ascending",
            "UPDATE table_name SET column_name = value;",
            "COUNT()",
            "A unique identifier for a record",
            "GROUP BY",
            "DROP TABLE table_name;",
            "To combine rows from two or more tables"
    };
}

