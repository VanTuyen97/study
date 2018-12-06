require_rel 'Person'
# require 'rspec'
module Human
    class Student < Person
        # overried method
        def display()
            super()
        end

        # access parent property
        def get_name()
            return @name
        end
    end
end