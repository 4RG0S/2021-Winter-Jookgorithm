import sys
from queue import PriorityQueue

input = sys.stdin.readline

n, k = map(int, input().split())

jew = PriorityQueue()

tmp = list()
bag = list()
for _ in range(n):
    tmp.append(list(map(int, input().split())))
for _ in range(k):
    bag.append(int(input()))

tmp.sort(key=lambda x : x[0])
bag.sort()

index = 0
ans = 0
for i in range(k):
    while index < n and bag[i] >= tmp[index][0]:
        jew.put(-tmp[index][1])
        index += 1
    if not jew.empty():
        ans += jew.get()

print(abs(ans))
