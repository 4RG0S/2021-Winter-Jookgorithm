# 에디터
import sys
from collections import deque
input = sys.stdin.readline

front = deque(list(input().strip()))
back = deque()
N = int(input())
for n in range(N):
    _input = input().strip().split()
    if _input[0]=='P':
        front.append(_input[1])
    elif _input[0]=='B' and len(front)>0:
        front.pop()
    elif _input[0]=='D' and len(back)>0:
        front.append(back.popleft())
    elif _input[0]=='L' and len(front)>0:
        back.appendleft(front.pop())
        
print(''.join(front)+''.join(back))