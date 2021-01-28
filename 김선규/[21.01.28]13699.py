dp = [1]
for i in range(35):
    n = 0
    for j in range(i+1):
        n += dp[j]*dp[i-j]
    dp.append(n)
print(dp[int(input())])