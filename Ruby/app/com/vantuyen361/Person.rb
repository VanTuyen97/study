module Human
    class Person
        @name
        @age
        def initialize (name, age)
            @name = name
            @age = age
        end
        def display()
            printf("name - " + @name + ", age - " + @age.to_s());
        end
    end 
end