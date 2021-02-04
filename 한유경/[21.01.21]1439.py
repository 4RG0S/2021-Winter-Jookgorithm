# 뒤집기
S = input()
current = -1
one = 0
zero = 0
for char in S:
    if char!=current:
        current = char
        if current=='1':
            one += 1
        else:
            zero += 1
print(min(one, zero))