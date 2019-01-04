from oop.classes import Person
from date_time import *


def string_test():
    # string is immutable => cannot be change
    print('"tuyen"') #  use quotes and double qoutes in string
    print("\"tuyen\"") #  backslashes in string
    print(r"C:\some\name") #  note the r before the quote
    print('''\
    \t write on mutiple lines
    \t write on mutiple lines''') # use """\...""" or '''\...'''
    print(3 * "tuyen") # concat many same string
    print("tuyen1"  "tuyen2") # can use "+"
    print("tuyen"[-1]) # index of string with length -1 >= number >= -length + 1
    print("tuyen"[1:4]) # substring from 1 to 4 in string
    print("tuyen"[1:]) # substring from 1 to end
    print("tuyen"[:1]) # substring from begin to 1 - 1
    print("tuyen"[:])
    # specifical chractor \n


def string_expression():
    """
    url: https://docs.python.org/3/library/string.html#format-string-syntax
    use f or F before (double or single)quote accept expression inner '{expression}'

    replacement_field ::=  "{" [field_name] ["!" conversion] [":" format_spec] "}"
        replacement field contained with a format to define
    field_name (list) ::=  arg_name ("." attribute_name | "[" element_index "]")*
    arg_name          ::=  [identifier | digit+]
    attribute_name    ::=  identifier
    element_index     ::=  digit+ | index_string
    index_string      ::=  <any source character except "]"> +

    conversion        ::=  "r" | "s" | "a"
        "r"           ::=repr() function
        "s"           ::=str() function
        "a"           ::=ascii() function

    format_spec       ::=  [[fill]align][sign][#][0][width][grouping_option][.precision][type]
        fill          ::=  <any character>
        align         ::=  "<[length]" | ">[length]" | "=" | "^"
            "<"       ::=  default, Forces the field to be left-aligned within the available space
            ">"       ::=  Forces the field to be right-aligned within the available space
            "="       ::=  Forces the padding to be placed after the sign (if any) but before the digits
            "^": Forces the field to be centered within the available space
        sign          ::=  "+" | "-" | " "
            '+'       ::=indicates that a sign should be used for both positive as well as negative numbers.
            '-'       ::=indicates that a sign should be used only for negative numbers (this is the default behavior).
            space     ::=indicates that a leading space should be used on positive numbers, and a minus sign on negative numbers.
        width         ::=  digit+
        grouping_option::=  "_" | ","
        precision     ::=  digit+
        type          ::=  "b" | "c" | "d" | "e" | "E" | "f" | "F" | "g" | "G" | "n" | "o" | "s" | "x" | "X" | "%"
    """
    person = Person(22, "tuyen")
    map = {'name': 'Tuyen', 'age': 22}
    name = "Tuyen"

    print(f'Hello {name:>}')
    print(f'{map["age"]:+}')
    print(f'{map["age"]: }')
    print(F"Hello {name}!")
    print(f'My name is {{name}}')  # need to include a brace character in text
    print(f'{map["name"]}') # access value in dict type by name keyword
    print(f'{person.age}') # access attribute of object


def format_align():
    s = "Hello Tuyen!"
    print(f"{s:>30}")
    print(f"{s:<10}")
    print(f"{s:^30}")
    # print(f"{s:=30}") # unknown


def format_sign():
    num1 = 100.234
    num2 = -100.234

    print(f'num1={num1:+}\t num2={num2:+}')
    print(f'num1={num1:-}\t num2={num2:-}')
    print(f'num1={num1: }\t num2={num2: }')


def format_conversion():
    name='Tuyen'
    age = 22

    print(f"{name!s}")  # replaced str() function, call __str__() function
    print(f"{name!r}")  # replaced repr() function
    print(f"{name!a}")  # replaced ascii() function


def format_type():
    """
    use hashtag (#) to define differently for different types
    'b'		::=  Binary format. Outputs the number in base 2.
    'c'		::=  Character. Converts the integer to the corresponding unicode character before printing.
    'd'		::=  Decimal Integer. Outputs the number in base 10.
    'o'		::=  Octal format. Outputs the number in base 8.
    'x'		::=  Hex format. Outputs the number in base 16, using lower-case letters for the digits above 9.
    'X'		::=  Hex format. Outputs the number in base 16, using upper-case letters for the digits above 9.
    'n'		::=  Number. This is the same as 'd', except that it uses the current locale setting to insert the appropriate number separator characters.
    'e'		::=  Exponent notation. The default precision is 6.
    'E'		::=  Exponent notation.
    'f'		::=  Fixed-point notation. The default precision is 6.
    'F'		::=  Fixed-point notation. Same as 'f', but converts nan to NAN and inf to INF.
    'g'		::=  General format.
    'G'		::=  General format.
    '%'		::=  Percentage. Multiplies the number by 100 and displays in fixed ('f') format, followed by a percent sign.
    None	::=  The same as 'd'.
    """
    num1 = 1997
    num2 = 0.5998
    s = 'Tuyen'

    print(f'{num1:#b}')
    # print(f'{num2:#c}')
    print(f'{num1:#d}')
    print(f'{num1:#o}')
    print(f'{num1:#x}')
    print(f'{num1:#X}')
    print(f'{num1:#n}')
    print(f'{num1:#e}')
    print(f'{num1:#E}')
    print(f'{num1:#f}')
    print(f'{num1:#F}')
    print(f'{num1:#g}')
    print(f'{num1:#G}')
    print(f'{num2:#3.4%}')
    print(f'{num2:#03.2f}')


def format_func():
    """
    use to replace f or F in string
    """
    lists = list(range(7))
    map = {'name':'Tuyen', 'age':22}
    name = "Tuyen"
    num1 = 3.14
    cur = datetime.now()

    print('%1.1f' % num1) # old format
    print("Hello {name}".format(name=name)) # specific name of argument to be use in string expression
    print("Hello {}".format(name))
    print("Hello {0}".format(name)) # specific index of argument refer
    print("revered array: {0[name]}".format(map)) # Accessing arguments’ items
    print("{!r}".format(name)) # format with conversion
    print("{:#03.2f}".format(num1)) # format type
    print("{:03.2f}".format(num1)) # ignore hashtag
    print("{:%Y-%m-%d}".format(cur)) # use specific formatting


def test():
    x = 1
    array = list(range(8))
    str_array = str(array)
    pattern = repr("x = {x}")
    print(f"array: {str_array!r}")


if __name__ == '__main__':
    format_func()