array = list(range(5))

print(*array) # argument unpacked from array (as print(1, 2, 3, 4, 5, 6))

t1, t2, t3, t4, t5 = array # unpacking
print(t1, t2, t3, t4, t5)