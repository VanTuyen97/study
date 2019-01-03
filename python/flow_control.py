def while_loop():
    index = 0
    while index < 1: # using while
        print(index)
        index += 1


def if_loop():
    index = 0
    if index < 0: # using if
        print('Negative changed to zero')
    elif index == 0:
        print('Zero')
    elif index == 1:
        print('One')
    else:
        pass # use in case block code is no action to be execute


def for_loop_list():
    str = ""
    array = list(range(5))
    for i in array: # for
        str = str + i.__str__()
    #     break
    #     continue
    # for i in range(5): # loop from 0 to 5
    #     str = str + i.__str__()
    # for i in array[:]: # Loop over a slice copy of the entire list.
    #     str = str + i.__str__()
    else:
        print(str)


def for_loop_list_reversed():
    """
    Reverse loop
    """
    lists = list(range(5))
    for value in reversed(lists):
        print(value)


def for_loop_list_enumerate():
    """
    index, value of list
    """
    array = list(range(3, 9))
    for index, value in enumerate(array):
        print(index, ": ", value)


def for_loop_list_zip():
    """
     loop over two or more list
     the times loop = minimum of list lengths
    """
    list1 = ["tuyen1", 'tuyen2', 'tuyen3']
    list2 = ['hoi1', 'hoi2', 'hoi3', 'hoi4']
    for var1, var2 in zip(list1, list2):
        print('var1: ', var1, ', var2: ', var2)


def for_loop_dict():
    dict = {'name': 'tuyen', 'age': 21}
    for key, value in dict.items():
        print(key, ": ",value)


for_loop_list_reversed()