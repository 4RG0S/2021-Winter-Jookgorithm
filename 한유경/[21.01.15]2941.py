# 크로아티아 알파벳
croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
_str = input()
for i in croatia:
    _str = _str.replace(i, ' ')
print(len(_str))