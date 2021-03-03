import sys

n = int(input())
m = int(input())
if m != 0:
    breakdown = list(map(int, input().split()))
elif m == 0:
    breakdown = []

if n == 100:
    print(0)
    sys.exit(0)

if m == 10:
    print(abs(n - 100))
    sys.exit(0)


def solve(target):
    global breakdown
    for i in str(target):
        i = int(i)
        if i in breakdown:
            return False
    return True


result = abs(n - 100)
for num in range(1000001):
    if solve(num):
        result = min(result, len(str(num)) + abs(n - num))

print(result)
