# import module.module1 # import module in package
# import module.module1 as module1 # import a module use alias
# from module import module1
from module import *
# from module.module1 import call_func # or *, import element of module

# print(module1.__name__) # name of module
# print(call_func.__name__) # name of function
# call_func()


# if __name__ == '__main__':
#     """
#     runner code
#     """
#     import winreg # This module provides access to the Windows registry API.
#     import sys # This module provides access to some objects used or maintained
#     # sys.argv[1] # access argument

person = Person()
person.getstring()