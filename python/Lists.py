# list is mutable (can change)
array = [1, 2, 3, 4, 5, 6] # initialization group value
arrays = [array, array] # nest list

print(*array) # argument unpacked from array (as print(1, 2, 3, 4, 5, 6))
print(arrays)
print(array) # call __str__() method
print(array[:4]) # slicing returns a new list
print(array[:]) # returns a new list contain all element
print(array + [7]) # concat lists


# remove element at index
copy_array = array[:]
# copy_array.remove(1) # remove a element, from 1
del copy_array[1:3] # remove elements
print(copy_array)


