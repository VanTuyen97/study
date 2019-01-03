class array_string:
    def __init__(self):
        self.index = 0
        self.__array = []

    def add(self, value):
        self.__array.append(value)

    def __iter__(self):
        self.index = self.__array.__len__()
        return self

    def __next__(self):
        """
        called by loop for.
        stop loop when raise a StopIteration exception
        """
        if self.index == 0:
            raise StopIteration
        self.index = self.index - 1
        return self.__array[self.index]

    def __reversed__(self):
        """
        call by reversed function in builtin
        """
        return reversed(self.__array)


if __name__ == '__main__':
    array = array_string()
    array.add("tuyen1")
    array.add("tuyen2")
    array.add("tuyen3")
    array.add("tuyen4")
    array.add("tuyen5")
    array.add("tuyen6")
    array.add("tuyen7")

    for value in reversed(array):
        print(value)