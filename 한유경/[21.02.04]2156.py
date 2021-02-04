# 포도주 시식
import sys
input = sys.stdin.readline

sys.setrecursionlimit(10000)

N = int(input())
_input = [int(input()) for _ in range(N)]
cnt = [[-1 for _ in range(N)] for i in range(2)]

def dp(n, t):
    global N, cnt, _input
    if n>=N:
        return 0
    if cnt[t][n]==-1:
        if t==1:
            cnt[t][n] = _input[n]+dp(n+2, 0)
        else:
            cnt[t][n] = max(_input[n]+max(dp(n+1, t+1), dp(n+2, 0)), dp(n+1, 0))
    return cnt[t][n]

print(max(dp(0, 0), dp(1, 0)))