# 피보나치 함수
import sys
input = sys.stdin.readline
cnt = [[0, 0] for i in range(41)]
cnt[0][0] = 1
cnt[1][1] = 1
last = 1

T = int(input())
for i in range(T):
    _input = int(input())
    while _input>last:
        last += 1
        cnt[last][0] = cnt[last-1][0]+cnt[last-2][0]
        cnt[last][1] = cnt[last-1][1]+cnt[last-2][1]
    print(cnt[_input][0], cnt[_input][1])
