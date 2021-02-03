# 제곱수의 합
from math import *
save = [-1]*100001

def dp(n):
    if save[n]!=-1:
        return save[n]
    _min = n
    for i in range(int(sqrt(n)), 0, -1):
        _n = n
        i2 = i*i
        temp = 0
        while _n>=i2:
            _n -= i2
            temp += 1
        temp += dp(n-i2*temp)
        if _min>temp:
            _min = temp
    save[n] = _min+1
    return save[n]

if __name__=="__main__":
    i = 1
    save[0] = 0
    while i*i<=100000:
        save[i*i] = 1
        i += 1
    print(dp(int(input())))