# 제로
import sys
from collections import deque
input = sys.stdin.readline

result = 0
stack = deque()
N = int(input())

for n in range(N):
    _input = int(input())
    if _input==0:
        _temp = stack.popleft()
        result -= _temp
    else:
        stack.appendleft(_input)
        result += _input

print(result)
