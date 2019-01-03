class A:
    def __init__(self):
        self.__private = "private"
        self._protect = "protected"
        self.public = "public"

    def __str__(self):
        return {'private':self.__private, 'protected':self._protected, 'public':self.public}


class B(A):
    def __str__(self):
        return {'protected':self._protected, 'public':self.public}


if __name__ == '__main__':
    b = B()
    print(b._protect)