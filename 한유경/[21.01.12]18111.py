# 마인크래프트
import sys
input = sys.stdin.readline
world = [0 for i in range(257)]
_min = 256
_max = 0


(N, M, B) = list(map(int, input().split(' ')))
for n in range(N):
    _input = list(map(int, input().split(' ')))
    for m in range(M):
        temp = _input[m]
        B += temp
        if temp>_max:
            _max = temp
        if temp<_min:
            _min = temp
        world[temp] += 1

S = B*2
B = B//(N*M)
if B>_max:
    B = _max
H = 0

for h in range(_min, B+1):
    _s = 0
    for i in range(257):
        if h==i:
            continue
        elif h>i:
            _s += (h-i)*world[i]
        else:
            _s += (i-h)*world[i]*2
    if S>=_s:
        H = h
        S = _s

print(S, H)