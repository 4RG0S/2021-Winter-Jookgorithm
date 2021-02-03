# 쉬운 계단 수
N = int(input())
cnt = [0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]

for n in range(1, N):
    temp = cnt.copy()
    for i in range(1, 11):
        cnt[i] = (temp[i-1] + temp[i+1])%1000000000
print(sum(cnt)%1000000000)