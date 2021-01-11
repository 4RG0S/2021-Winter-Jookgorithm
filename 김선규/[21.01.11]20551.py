import sys

n, m = map(int, sys.stdin.readline().split())
li = sorted([int(sys.stdin.readline()) for i in range(n)])
dic = {}
for i in range(n):
    try:
        dic[li[i]]
    except:
        dic[li[i]] = i
for i in range(m):
    try:
        print(dic[int(sys.stdin.readline())])
    except:
        print(-1)