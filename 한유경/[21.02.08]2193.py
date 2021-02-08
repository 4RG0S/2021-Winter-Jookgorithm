# 이친수
N = int(input())-2
if N<=0:
    print(1)
else:
    _one = 0
    _zero = 1
    while N>0:
        _temp = _zero
        _zero += _one
        _one = _temp
        N -= 1
    print(_one+_zero)