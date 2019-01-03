# Python
## Concept
1. [Module](https://docs.python.org/3/tutorial/modules.html): is a file (.py) containing Python definitions and statements.
## Reference
1. [Docs](https://docs.python.org/3/tutorial/index.html)
2. [The Python Standard Library](https://docs.python.org/3/library/index.html)
    - [Built-in](https://docs.python.org/3/library/functions.html)
    
## Structure
1. [List](https://docs.python.org/3/tutorial/datastructures.html#more-on-lists)
    - [List as Stack](https://docs.python.org/3/tutorial/datastructures.html#more-on-lists): use `pop()` and `append()` method.
    - [List as Queues](https://docs.python.org/3/tutorial/datastructures.html#using-lists-as-queues): use `popleft()` and `append()` method.
## Ruler
1. Name of package, file, class and variable are different

## Runner
 ```cmd
 python <file.py> <argument>
 ```
 
## Structure
```
top_package/                    Top-level package
      __init__.py               Required to initialize this package
      subpackage/               Subpackage for file format conversions
              __init__.py
              sources.py
              ...
```