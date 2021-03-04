# AC
import sys
from collections import deque
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    p = input().strip()
    n = int(input())
    _input = input().strip()
    array = []
    if len(_input)>2:
        array = deque(list(map(int, _input[1:len(_input)-1].split(','))))
    R = False
    error = False
    for i in list(p):
        if i=='R':
            R = not R
        else:
            if len(array)==0:
                print("error")
                error = True
                break
            if R:
                array.pop()
            else:
                array.popleft()
    if not error:
        S = '['
        while len(array)>0:
            if R:
                S += str(array.pop())+','
            else:
                S += str(array.popleft())+','
        if S[len(S)-1]==',':
            S = S[:len(S)-1]+']'
        else:
            S += ']'
        print(S)