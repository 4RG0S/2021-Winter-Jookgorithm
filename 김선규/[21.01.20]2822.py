li = sorted([[int(input()),i] for i in range(8)])
s = 0
ans = []
for i in range(3,8):
    s += li[i][0]
    ans.append(li[i][1]+1)
print(s)
print(*sorted(ans))