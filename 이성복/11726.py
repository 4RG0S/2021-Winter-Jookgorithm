dp = [1, 2, 3]

for i in range(3, 1000):
    dp.append(dp[i - 2] + dp[i - 1])


print(dp[int(input()) - 1] % 10007)