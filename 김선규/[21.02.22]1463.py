n = int(input())
dp = [0,0,1,1]
for i in range(4, n+1):
    li = [dp[i-1]]
    if i % 2 == 0:
        li.append(dp[int(i/2)])
    if i % 3 == 0:
        li.append(dp[int(i/3)])
    dp.append(min(li)+1)
print(dp[n])