print("range: " + range(5).__str__()) # as indexing from the end of the sequence
print("range: " + range(1, 5, 2).__str__()) # range(start, stop[, step]

# create list
print("list: " + list(range(5)).__str__())
print("list: " + list(map(lambda x: x**2, range(5))).__str__())

#create set
print("set: " + set(range(5)).__str__())