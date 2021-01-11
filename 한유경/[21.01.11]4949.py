# 균형잡힌 세상
import sys
from collections import deque
input = sys.stdin.readline

stack = deque()
result = True
_input = input().replace("\n", '')

while _input!=".":
    for i in _input:
        if i=='{' or i=='[' or i=='(':
            stack.appendleft(i)
        elif i=='}':
            if len(stack)==0 or stack[0]!='{':
                result = False
                break
            else:
                stack.popleft()
        elif i=="]":
            if len(stack)==0 or stack[0]!='[':
                result = False
                break
            else:
                stack.popleft()
        elif i==")":
            if len(stack)==0 or stack[0]!='(':
                result = False
                break
            else:
                stack.popleft()
    
    if len(stack)!=0:
        result = False

    if result:
        print('yes')
    else:
        print('no')
    _input = input().replace("\n", '')
    stack = deque()
    result = True