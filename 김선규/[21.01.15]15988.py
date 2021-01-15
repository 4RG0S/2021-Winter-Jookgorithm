import sys

li = [0, 1, 2, 4]
for i in range(3, 1000000):
    li.append((li[i]+li[i-1]+li[i-2])%1000000009)
t = int(sys.stdin.readline())
for i in range(t):
    n = int(sys.stdin.readline())
    print(li[n])