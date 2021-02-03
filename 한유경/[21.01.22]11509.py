# 풍선 맞추기
save = [0]*1000001
N = int(input())
balloons = list(map(int, input().split(' ')))
for i in range(N):
    if save[balloons[i]]!=0:
        save[balloons[i]] -= 1
    save[balloons[i]-1] += 1
print(sum(save))