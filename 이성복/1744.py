plus = []
minus = []
zero = False
result = []

for _ in range(int(input())):
    tmp = int(input())
    if tmp < 0:
        minus.append(tmp)
    elif tmp > 0:
        plus.append(tmp)
    else:
        zero = True

plus.sort(reverse=True)
minus.sort()

while len(plus) > 1:
    if plus[1] != 1:
        result.append(plus.pop(0) * plus.pop(0))
    elif plus[1] == 1 and len(plus):
        break

while len(minus) > 1:
    result.append(minus.pop(0) * minus.pop(0))

ans = sum(result)
while plus:
    ans += plus.pop(0)
if minus:
    if zero:
        pass
    else:
        ans += minus[0]

print(ans)