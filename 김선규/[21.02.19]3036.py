def gcd(m, n):
    while n != 0:
        t = m % n
        m, n = n, t
    return abs(m)

n = int(input())
li = list(map(int, input().split()))
for i in range(1, n):
    m = gcd(li[0],li[i])
    print(str(int(li[0]/m))+"/"+str(int(li[i]/m)))