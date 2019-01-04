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
## Modules often use
1. [os](https://docs.python.org/3/library/os.html#module-os): interacting with the operating system
2. [glob](https://docs.python.org/3/library/glob.html#module-glob): finds all the pathnames to be specific pattern string.
3. [sys](https://docs.python.org/3/library/sys.html#module-sys): access to some variables used or maintained by the interpreter and to functions that interact strongly with the interpreter.
4. [re](https://docs.python.org/3/library/re.html#module-re): provides regular expression tools.
5. [math](https://docs.python.org/3/library/math.html#module-math): provides access to the mathematical functions defined by the C standard.
6. [urllib.request](https://docs.python.org/3/library/urllib.request.html#module-urllib.request): defines functions and classes which help send request with url.
7. [datetime](https://docs.python.org/3/library/datetime.html#module-datetime): support date time in python.
8. [zlib](https://docs.python.org/3/library/zlib.html#module-zlib), [gzip](https://docs.python.org/3/library/gzip.html#module-gzip), [bz2](https://docs.python.org/3/library/bz2.html#module-bz2), [lzma](https://docs.python.org/3/library/lzma.html#module-lzma), [zippfile](https://docs.python.org/3/library/zipfile.html#module-zipfile), [tarfile](https://docs.python.org/3/library/tarfile.html#module-tarfile): support to archive and compress data.
9. 