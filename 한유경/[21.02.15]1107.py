# 리모컨
N = int(input())
_break = int(input())
cnt = [True for i in range(1000001)]

if _break==0:
    print(min(abs(100-N), len(str(N))))
else:
    _b = list(map(int, input().split()))
    for i in _b:
        cnt[i] = False
    
    result = abs(100-N)

    for i in range(1000000):
        new_result = abs(100-N)
        if len(str(i))==1 and cnt[i]:
            new_result = 1 + abs(i-N)
        else:
            if cnt[i%10] and cnt[i//10]:
                new_result = len(str(i))+abs(i-N)
            else:
                cnt[i] = False
        if result>new_result:
            result = new_result
    print(result)