require 'rspec'
require 'require_all'
require_all './app/com/vantuyen361'

person = Human::Student.new("tuyen", 20)
person.display()
print person.get_name()