n, l = map(int, input().split())
li = sorted(list(map(int, input().split())))
for i in li:
    if i <= l:
        l += 1
print(l)