# Z
(N, r, c) = list(map(int, input().split()))
cnt = [-1 for i in range(30)]
cnt[0] = 1
cnt[1] = 2
def squared(n):
    global cnt
    if cnt[n]==-1:
        result = squared(n//2)
        result *= result
        if n%2==1:
            result *= 2
        cnt[n] = result
    return cnt[n]

def dp(n, y, x):
    if n==1:
        return y*2+x
    result = squared(2*(n-1))*((y//(squared(n-1)))*2+(x//(squared(n-1))))
    return result+dp(n-1, y%(squared(n-1)), x%(squared(n-1)))

print(dp(N, r, c))