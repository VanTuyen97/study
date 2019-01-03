from classes import Person

class Student(Person):
    """
    extend Person class
    The element to be inherit by base class the order from left to right
    """
    pass

if __name__ == '__main__':
    student = Student(21, "tuyen")
    print(dir(student))
    print(student.class_var)
    print(student.__str__())