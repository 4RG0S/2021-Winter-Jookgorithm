from collections import defaultdict

n = int(input())
tree = list()
for _ in range(n):
    tree.append(list(map(int, input().split())))

dp = defaultdict(lambda: defaultdict(int))


def func(k, x):
    if k + 1 == n:
        return tree[k][x]
    if dp[k][x] != 0:
        return dp[k][x]
    dp[k][x] = tree[k][x] + max(func(k + 1, x), func(k + 1, x + 1))
    return dp[k][x]


print(func(0, 0))