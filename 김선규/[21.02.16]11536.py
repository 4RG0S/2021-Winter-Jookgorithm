n = int(input())
a = [input() for _ in range(n)]
b = sorted(a)
if a == b:
    print("INCREASING")
elif a == b[::-1]:
    print("DECREASING")
else:
    print("NEITHER")