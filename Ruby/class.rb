class Person
    @name
    @age
    def initialize (name, age)
        @name = name
        @age = age
    end
    
    def get_name ()
        return name
    end

    def display()
        printf("name - " + @name + ", age - " + @age.to_s)
    end
end

class Student < Person
    
end

person = Student.new("tuyen", 20)
person.display()