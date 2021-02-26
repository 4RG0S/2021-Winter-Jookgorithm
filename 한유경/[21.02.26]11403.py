# 경로 찾기
import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
E = [input().strip().split() for n in range(N)]

for n in range(N):
    queue = deque([n])
    visited = [False for i in range(N)]
    while len(queue)>0:
        temp = queue.popleft()
        for i in range(N):
            if E[temp][i]=='1':
                if not visited[i]:
                    E[n][i] = '1'
                    visited[i] = True
                    queue.append(i)
for e in E:
    print(' '.join(e))