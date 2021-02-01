n = int(input())
li = []
for _ in range(n):
    i = input().split()
    li.append([i[0]]+list(map(int, i[1:])))
li = sorted(li, key=lambda x:(x[3], x[2], x[1]))
print(li[n-1][0])
print(li[0][0])