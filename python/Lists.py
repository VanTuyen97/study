def list_structure():
    """
     list is mutable (can change)
    """

    # initialization group value
    array = [1, 2, 3, 4, 5, 6]
    arrays = [array, array] # nest list

    print(*array) # argument unpacked from array (as print(1, 2, 3, 4, 5, 6))
    print(arrays)
    print(array) # call __str__() method
    print(array[:4]) # slicing returns a new list
    print(array[:]) # returns a new list contain all element
    print(array + [7]) # concat lists

    # remove element at index
    copy_array = array[:]
    copy_array.remove(3) # remove a element, from 1
    # del copy_array[1:3] # remove elements
    print(copy_array)
    __main__


def tuple_structure():
    """
    tuples is a list immutable
    """

    # initialization
    # arr = [1, 2], [1, 2]
    tuple = ([1, 2], [1, 2])
    print("arr: " + tuple.__str__())

    tuple[1][1] = 0
    print("arr: " + tuple.__str__())


def set_structure():
    """
    set is list no duplicate element
    """
    set = {1, 2, 3, 4, 1} # only get one element (many the same element)
    print(set)


def dict_structure():
    """
    the same json type
    """
    # dic = {'name': 'tuyen', 'age': 97}
    dic = dict([('name', 'tuyen'), ('age', 97)])
    print(dic['name']) # access value of element

    dic["birthday"] = 1997
    print(dic)

    for key, value in dic.items():
        print(key, ": ", value)
list_structure()