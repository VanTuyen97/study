var = "golbal variable"
print('=====scope variable=====')

def local_variable():
    """
    local variable to be use inner function
    """
    var = "local variable"


def nonlocal_variable():
    """
    none local variable to be use inner function
    """
    var = "none local"

    def inner_func():
        nonlocal var
        var = var + " was used inner method"

    inner_func()
    print('print nonelocal:', var)


def global_variable():
    """
    access global variable
    """
    global var
    var = 'access ' + var



global_variable()
print("print variable:", var)