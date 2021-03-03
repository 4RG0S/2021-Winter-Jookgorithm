import sys
from queue import PriorityQueue

input = sys.stdin.readline

num = PriorityQueue()
for _ in range(int(input())):
    num.put(int(input()))

ans = 0
while num.qsize() != 1:
    tmp = num.get() + num.get()
    ans += tmp
    num.put(tmp)

print(ans)
