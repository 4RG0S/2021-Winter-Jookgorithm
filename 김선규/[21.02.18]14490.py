x, y = map(int, input().split(":"))
a, b = x, y
while b != 0:
    c = a % b
    a, b = b, c
print(str(int(x/a))+":"+str(int(y/a)))