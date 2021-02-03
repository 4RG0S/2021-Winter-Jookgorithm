# 숨바꼭질
from collections import deque
(N, K) = list(map(int, input().split()))
booked = [False]*200000
queue = deque([(N, 0)])
while len(queue)!=0:
    here = queue.popleft()
    if booked[here[0]]:
        continue
    booked[here[0]] = True
    if here[0]==K:
        print(here[1])
        break
    else:
        if here[0]>=1:
            queue.append((here[0]-1, here[1]+1))
        if here[0]<K:
            queue.append((here[0]+1, here[1]+1))
        if here[0]<100000:
            queue.append((here[0]*2, here[1]+1))
