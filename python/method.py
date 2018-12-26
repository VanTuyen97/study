var = "var"


def hello(first_name="Everyone", last_name=""):
    """
    default value: use with param from right to left
    function must call below declare function
    """
    print("Hello " + first_name.__str__() + last_name + "!")


def f(a, L=[]):
    """
    :param L: The default value of L is evaluated only once, can share to between subsequent calls.
    """
    L.append(a)
    return L


def list_argument(*arguments):
    """
    :param arguments: use prefix * to accept list argument
    """
    for arg in arguments:
        print(arg)


def map_type_argument(**arguments):
    """
    :param arguments: receives dictionary (map type) argument
    """
    for arg in arguments:
        print(arg.__str__() + ": " + arguments[arg].__str__())


if __name__ == '__main__':
    print(hello.__doc__) # print documentation string
    hello(last_name=" Nguyen Van", first_name="Tuyen") # pass argument to function use keyword argument
    print(f(1))
    print(f(2))
    list_argument("tuyen1", "tuyen2", "tuyen3")
    map_type_argument(name = "Tuyen", age = 97)