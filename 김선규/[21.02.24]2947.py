li = list(map(int, input().split()))
while True:
    for i in range(4):
        if li[i] > li[i+1]:
            break
    else:
        break
    for i in range(4):
        if  li[i] > li[i+1]:
            li[i], li[i+1] = li[i+1], li[i]
            print(*li)