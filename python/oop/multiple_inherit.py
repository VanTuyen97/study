class Base1():
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def __str__(self):
        return {'name':self.name, 'age':self.age}


class Base2():
    def __init__(self,name, age):
        self.age = age
        self.name = name

    def __str__(self):
        return {'name':self.name, 'age':self.age}


class Base3():
    def __init__(self, message):
        self.message = message

    def __str__(self):
        return {'message':self.message}


class Inherit(Base1, Base2, Base3):
    def __init__(self, name1, name2, age1, age2, message):
        Base1.__init__(self, name1, age1)
        Base2.__init__(self, name2, age2)
        Base3.__init__(self, message)

    def __str__(self):
        return {"name":self.name, 'age':self.age, 'message':self.message}


if __name__ == '__main__':
    inherit = Inherit("tuyen1", "tuyen2", 21, 22, "Hello")

    print(inherit.__str__())
    print(Base1.__str__(inherit)) # using function of Base1 class
