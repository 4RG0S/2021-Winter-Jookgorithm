n, d = map(int, input().split())
dic = {}
for i in range(10):
    dic[i] = 0
for i in range(1, n+1):
    s = str(i)
    for j in s:
        dic[int(j)] += 1
print(dic[d])