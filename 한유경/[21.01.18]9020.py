# 골드바흐의 추측
import sys
input = sys.stdin.readline

# first, compute prime numbers
MAX = 10000
save = [-1]*MAX
save[0]=0
last = 1
while last<MAX:
    while last<MAX:
        if save[last]==-1:
            break
        last += 1
    if last==MAX:
        break
    save[last] = 1
    last += 1
    for i in range(last*2-1, MAX, last):
        save[i] = 0

# second, get input and compute result
N = int(input())
for i in range(N):
    n = int(input())
    if n==4:
        print(2, 2)
    else:  
        _max = 0
        prime_1 = (n//2 if n%4==0 else n//2-1)
        for k in range(2, prime_1+1, 2):
            if save[k]==1:
                if save[n-k-2]==1:
                    _max = k
        if _max+1<n-_max-1:
            print(_max+1, n-_max-1)
        else:
            print(n-_max-1, _max+1)