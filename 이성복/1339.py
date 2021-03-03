import math
import sys


string = list()
n = int(sys.stdin.readline().strip())
for _ in range(n):
    string.append(sys.stdin.readline().strip())

alpha = [0 for _ in range(26)]
for word in string:
    for i, s in enumerate(word):
        alpha[ord(s) - ord('A')] += math.pow(10, len(word) - (i + 1))

alpha.sort(reverse=True)
result = 0
for i in range(9, 0 , -1):
    result += i * alpha[9 - i]

print(int(result))