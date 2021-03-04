# 맥주 마시면서 걸어가기
import sys
from collections import deque
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N = int(input())
    place = [list(map(int, input().split())) for n in range(N+2)]
    d = [abs(place[i][0]-place[N+1][0])+abs(place[i][1]-place[N+1][1]) for i in range(N+2)]

    queue = deque([0])
    success = False
    visited = [False for i in range(N+2)]
    visited[0] = True

    while len(queue)>0:
        now = queue.popleft()
        if d[now]==0:
            success = True
            break
        for i in range(1, N+2):
            if not visited[i] and 1000>=abs(place[now][0]-place[i][0])+abs(place[now][1]-place[i][1]):
                    queue.append(i)
                    visited[i] = True

    if success:
        print("happy")
    else:
        print("sad")