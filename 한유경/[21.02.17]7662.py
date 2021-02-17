# 이중 우선순위 큐
import sys
import heapq
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N = int(input())
    _max_h = []
    _min_h = []
    dic = dict()
    for n in range(N):
        (m, v) = input().split()    # m : method, v : value
        if m=='I':          # insert
            heapq.heappush(_max_h, (-int(v), int(v)))
            heapq.heappush(_min_h, (int(v), int(v)))
            if int(v) in dic:
                dic[int(v)] += 1
            else:
                dic[int(v)] = 1
        else:               # delete
            if len(_min_h)==0 or len(_max_h)==0:
                _min_h = []
                _max_h = []
                continue
            if int(v)==1:
                while dic[_max_h[0][1]]==0:
                    heapq.heappop(_max_h)
                    if len(_max_h)==0:
                        break
                if len(_max_h)>0:
                    dic[heapq.heappop(_max_h)[1]] -= 1
                    
            else:
                while dic[_min_h[0][1]]==0:
                    heapq.heappop(_min_h)
                    if len(_min_h)==0:
                        break
                if len(_min_h)>0:
                    dic[heapq.heappop(_min_h)[1]] -= 1

    if len(_max_h)==0 or len(_min_h)==0:
        print("EMPTY")
    else:
        while dic[_max_h[0][1]]==0:
            heapq.heappop(_max_h)
            if len(_max_h)==0:
                break
        while dic[_min_h[0][1]]==0:
            heapq.heappop(_min_h)
            if len(_max_h)==0:
                break
        if len(_max_h)==0 or len(_min_h)==0:
            print("EMPTY")
        else:
            print(_max_h[0][1], _min_h[0][1])