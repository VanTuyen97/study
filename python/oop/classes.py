# The method function is declared with an explicit first argument representing the object (self)
# The term method is not unique to class instances
# All member functions are virtual


# namespace is a mapping from names to objects

def sum(self, num1, num2):
    """
     Function defined outside the class
    """
    print(num1 + num2)


class Person:
    class_var = "person"  # variable of class (access by name of class or object)

    sum = sum  # reference to method outer class

    def __init__(self, age, name):
        """
        The instantiation operation creates an empty object.
        """
        # variable of object
        # public variable
        self.age = age
        self.name = name

    def display(self):
        print("name:", self.name)
        print("age:", self.age)

    def func():
        """
        access by name class
        """
        print("don't pass self")

    def __str__(self, *args, **kwargs):
        return {'name': self.name, 'age': self.age}



if __name__ == '__main__':
    person = Person(21, "Tuyen")  # new a instance of the Person class
    person.display()
    person.sum(4, 6)

    print(person.class_var)
