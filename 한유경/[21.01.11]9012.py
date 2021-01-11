# 괄호
import sys
from collections import deque
input = sys.stdin.readline

N = int(input())

for n in range(N):
    _input = input().replace("\n", '')
    stack = deque()
    result = True

    for i in _input:
        if i=='(':
            stack.appendleft(i)
        elif i==")":
            if len(stack)==0 or stack[0]!='(':
                result = False
                break
            else:
                stack.popleft()
    
    if len(stack)!=0:
        result = False

    if result:
        print('YES')
    else:
        print('NO')
