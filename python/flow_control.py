index = 0
array = [1, 2, 3, 4, 5, 6, 7]
str = ""

while index < 1: # using while
    print(index)
    index += 1


if index < 0: # using if
    print('Negative changed to zero')
elif index == 0:
    print('Zero')
elif index == 1:
    print('One')
else:
    print('More')


for i in array: # for
    str = str + i.__str__()
#     break
#     continue
# for i in range(5): # loop from 0 to 5
#     str = str + i.__str__()
# for i in array[:]: # Loop over a slice copy of the entire list.
#     str = str + i.__str__()
else:
    print(str)


if True:
    pass # use in case block code is no action to be execute

