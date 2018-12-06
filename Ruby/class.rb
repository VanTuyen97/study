class Person
    # attr_reader(:name, :age) # getter method
    # attr_writer(:name, :age) # setter method
    attr_accessor(:name, :age) # bother getter and setter method
    def initialize
        @name = "tuyen" 
        @age = 60
    end

    def display()
        printf("name - " + @name + ", age - " + @age.to_s)
    end
end

person = Person.new
person.name = "Tuyen97" # set value Tuyen97
print person.name # => Tuyen97
# person.display()
