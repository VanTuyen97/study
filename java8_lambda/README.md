# Lambda expression in java 8
## Docs
1. [Lambda-QuickStart](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html).
## Concept: 
1. **Lambda expressions**: Improve the collection libraries to making it easier to iterate through, filter, and extract data from a collection
    - Impove performace in multicore environments.
    - Convert five lines code into a single statement.
2. **Anonymous inner class**: is inner class without a name and for which only a single object created.
3. **Functional interfaces**: is an interface with only one method. 
    - [Predicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html): This is a functional interface whose functional method is test(Object). 
    - Consumer: An action to be performed with the object passed as argument
    - Function: Transform a T to a U
    - Supplier: Provide an instance of a T (such as a factory)
    - UnaryOperator: A unary operator from T -> T
    - BinaryOperator: A binary operator from (T, T) -> T
4. **Inner class**: is class declared entirely within the body of another class or interface. 
