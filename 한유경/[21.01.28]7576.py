# 토마토
import sys
from collections import deque
input = sys.stdin.readline

(M, N) = list(map(int,input().split()))
node = []    # start node
amount = M*N
cnt = [[-2 for m in range(M+2)] for n in range(N+2)]

for n in range(N):
    temp = list(map(int, input().split()))
    for i in range(M):
        if temp[i]==-1:
            temp[i] = -2
            amount -= 1
        else:
            if temp[i]==1:
                node.append((n+1, i+1, 0))
                temp[i] = 0
                amount -= 1
            else:
                temp[i] = -1
    cnt[n+1][1:M+1] = temp

queue = deque(node)     # for BFS
_max = -1
while len(queue)!=0:
    temp = queue.popleft()
    cnt[temp[0]][temp[1]] = temp[2]
    if _max< temp[2]:
        _max = temp[2]

    if cnt[temp[0]-1][temp[1]]==-1:
        cnt[temp[0]-1][temp[1]] = -2
        amount -= 1
        queue.append((temp[0]-1, temp[1], temp[2]+1))
    if cnt[temp[0]+1][temp[1]]==-1:
        cnt[temp[0]+1][temp[1]] = -2
        amount -= 1
        queue.append((temp[0]+1, temp[1], temp[2]+1))
    if cnt[temp[0]][temp[1]-1]==-1:
        cnt[temp[0]][temp[1]-1] = -2
        amount -= 1
        queue.append((temp[0], temp[1]-1, temp[2]+1))
    if cnt[temp[0]][temp[1]+1]==-1:
        cnt[temp[0]][temp[1]+1] = -2
        amount -= 1
        queue.append((temp[0], temp[1]+1, temp[2]+1))
if amount!=0:
    print(-1)
else:
    print(_max)