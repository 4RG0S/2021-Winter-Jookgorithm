import sys
n, m = map(int, sys.stdin.readline().split())
dic = {}
for i in range(1, n+1):
    s = sys.stdin.readline().rstrip('\n')
    dic[s] = i
    dic[str(i)] = s
for i in range(m):
    print(dic[sys.stdin.readline().rstrip('\n')])