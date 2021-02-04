# 최대 힙
import sys
import heapq
input = sys.stdin.readline

N = int(input())
heap = []

for _ in range(N):
    _input = int(input())
    if _input==0:
        if len(heap)==0:
            print(0)
        else:
            print(-heapq.heappop(heap))
    else:
        heapq.heappush(heap, -_input)