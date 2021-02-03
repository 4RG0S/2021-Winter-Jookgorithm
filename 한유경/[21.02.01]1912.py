# 연속합
import sys
input = sys.stdin.readline

N = int(input())
result = -1000
cnt = [0 for _ in range(N)]
_input = list(map(int, input().split()))

def dp(n, _input):
    global cnt, result
    if n==0:
        cnt[0] = _input
    else:
        cnt[n] = (_input if cnt[n-1]+_input<_input else cnt[n-1]+_input)
    if cnt[n]>result:
        result = cnt[n]
    return cnt[n]

for n in range(N):
    dp(n, _input[n])
print(result)