n = int(input())

li = [0, 1, 1]
for _ in range(1, n):
    li[1] = li[0]
    li[0] = li[2]
    li[2] = li[1] + li[0]
print(li[2])