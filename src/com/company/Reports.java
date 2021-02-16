package com.company;

// An interface is a list of abstract methods
// any class that promises to implement the interface must write these methods
// An interface forces similar classes to have the same methods (but implemented in a different way)
public interface Reports {
    public abstract void printDetailedReport();
    public abstract void printSummary();

}
