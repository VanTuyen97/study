# agrument for method
def print_name (arg1, arg2)
    print arg1 + " " + arg2 + "\n";
end

# return method
def return_name ()
    return "tuyen"
end

# aliases method
alias aliases print_name

aliases("Nguyen Van", "Tuyen")
print_name("Nguyen Van", "Tuyen")
print return_name() + "\n"