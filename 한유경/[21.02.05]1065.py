# 한수
from collections import deque

queue = deque()
N = int(input())
cnt = [0 for i in range(10001)]
for i in range(1, 10):
    cnt[i] = 1
    queue.append((i, -10))

while len(queue)!=0:
    temp = queue.popleft()
    if temp[1]==-10:
        t = 0
        while t<10:
            if temp[0]+t>=10:
                break
            index = temp[0]*11+t
            cnt[index] = 1
            queue.append((index, t))
            t += 1
        t = 1
        while temp[0]-t>=0:
            index = temp[0]*11-t
            cnt[index] = 1
            queue.append((index, -t))
            t += 1
    else:
        _one = temp[0]%10+temp[1]
        if _one<10 and _one>=0:
            index = temp[0]*10+_one
            if index>10000:
                continue
            cnt[index] = 1
            queue.append((index, temp[1]))
print(sum(cnt[:N+1]))