n = int(input())
s = set()
for _ in range(n):
    s.add(tuple(sorted(input())))
print(len(s))