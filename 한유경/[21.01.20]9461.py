# 파도반 수열
import sys
input = sys.stdin.readline

save = [-1]*100
save[0] = 1
save[1] = 1
save[2] = 1
save[3] = 2
save[4] = 2
last = 5

T = int(input())

for t in range(T):
    temp = int(input())-1
    if save[temp]!=-1:
        print(save[temp])
    else:
        while last<=temp:
            if last%2==0:
                save[last] = save[last-1]+save[last-5]
            else:
                save[last] = save[last-1]+save[last-5]
            last += 1
        print(save[temp])
