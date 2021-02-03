# 터렛
import sys
import math
input = sys.stdin.readline

N = int(input())
for n in range(N):
    (x1, y1, r1, x2, y2, r2) = list(map(int, input().split(' ')))
    r = math.sqrt((x1-x2)**2+(y1-y2)**2)
    
    # case 0 : find infinity locations
    if r==0 and r1==r2:
        print(-1)
    # case 1 : can't find location
    elif r>r1+r2:
        print(0)
    elif (r1 if r1>r2 else r2)>r+(r2 if r1>r2 else r1):
        print(0)
    # case 2 : find one location
    elif r==r1+r2:
        print(1)
    elif (r1 if r1>r2 else r2)==r+(r2 if r1>r2 else r1):
        print(1)
    # case 3 : find two location
    elif r<r1+r2:
        print(2)
    elif (r1 if r1>r2 else r2)<r+(r2 if r1>r2 else r1):
        print(2)