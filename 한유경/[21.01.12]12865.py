# 평범한 배낭
import sys
input = sys.stdin.readline

cache = [[-1 for i in range(100001)] for j in range(100)]
item = []
N = 0
K = 0

def pack(weight, index):
    global N, K, item, cache
    if index==N:
        return 0
    temp = cache[index][weight]

    # case 0: already compute it,
    if temp!=-1:
        return temp

    # case 1: don't pack this item
    temp = pack(weight, index+1)

    # case 2: pack this item(if i can)
    if weight>=item[index][0]:
        temp2 = pack(weight-item[index][0], index+1)+item[index][1]
        # choose bigger one
        if temp<temp2:
            temp = temp2

    # save result
    cache[index][weight] = temp
    return temp


# get input data
(N, K) = list(map(int, input().split(' ')))
for n in range(N):
    (_w, _v) = list(map(int, input().split(' ')))
    item.append((_w, _v))

# compute and print result
print(pack(K, 0))