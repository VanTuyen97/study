import sys
from oop.multiple_inherit import Inherit, Base1

lists = list(range(6))

def range_func():
    print("range: " + range(5).__str__()) # as indexing from the end of the sequence
    print("range: " + range(1, 5, 2).__str__()) # range(start, stop[, step]

def list_func():
    # create list
    print("list: " + list(range(5)).__str__())
    print("list: " + list(map(lambda x: x**2, range(5))).__str__())

def set_func():
    #create set
    print("set: " + set(range(5)).__str__())

def dir_func():
    """
    return all name of element can call of argument
    """
    print(dir(sys))

def isinstance_func():
    var = 9
    print(isinstance(var, int))


def issubclass_func():
    """
    whether a class is subclass of other class
    """
    print(issubclass(Inherit, Base1))

if __name__ == '__main__':
    issubclass_func()
