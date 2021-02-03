# 1로 만들기
cnt = [-1]*1000001
cnt[0] = 0
cnt[1] = 0
cnt[2] = 1
cnt[3] = 1
N = int(input())

for i in range(4, N+1):
    cnt[i] = cnt[i-1]+1
    if i%3==0:
        cnt[i] = min(cnt[i], cnt[i//3]+1)
    if i%2==0:
        cnt[i] = min(cnt[i], cnt[i//2]+1)
print(cnt[N])