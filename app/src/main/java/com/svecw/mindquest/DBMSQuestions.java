package com.svecw.mindquest;

public class DBMSQuestions {
    public static String[] question = {
            "What does DBMS stand for?",
            "Which of the following is a type of DBMS?",
            "What is a primary key?",
            "What is normalization in DBMS?",
            "Which SQL statement is used to retrieve data from a database?",
            "What does the acronym ACID stand for in DBMS?",
            "Which of the following is not a type of join in SQL?",
            "What is the purpose of an index in a database?",
            "What is a foreign key?",
            "Which command is used to delete a table in SQL?"
    };

    public static String[][] choices = {
            {"Database Management System", "Data Base Management System", "Database Management Service", "Data Base Management Service"},
            {"Hierarchical", "Network", "Relational", "All of the above"},
            {"A unique identifier for a record", "A key that allows duplicates", "A key for indexing", "None of the above"},
            {"Combining data from multiple tables", "Reducing data redundancy", "Increasing data redundancy", "None of the above"},
            {"SELECT", "GET", "RETRIEVE", "FETCH"},
            {"Atomicity, Consistency, Isolation, Durability", "Access, Consistency, Integrity, Durability", "Atomicity, Consistency, Integrity, Data", "Access, Consistency, Isolation, Data"},
            {"Inner Join", "Outer Join", "Left Join", "Aggregate Join"},
            {"To speed up data retrieval", "To increase redundancy", "To enforce data integrity", "To store data"},
            {"A key that links two tables", "A key that allows duplicates", "A key used for indexing", "None of the above"},
            {"DROP", "DELETE", "REMOVE", "TRUNCATE"}
    };

    public static String[] correctAnswers = {
            "Database Management System",
            "All of the above",
            "A unique identifier for a record",
            "Reducing data redundancy",
            "SELECT",
            "Atomicity, Consistency, Isolation, Durability",
            "Aggregate Join",
            "To speed up data retrieval",
            "A key that links two tables",
            "DROP"
    };
}
