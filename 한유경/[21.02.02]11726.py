# 2×n 타일링
N = int(input())

def dc(n):
    if n<=1:
        return [[1, 1], [1, 0]]
    else:
        temp = dc(n//2)
        t0 = temp[0][0]*temp[0][0]+temp[0][1]*temp[1][0]
        t1 = temp[0][0]*temp[0][1]+temp[0][1]*temp[1][1]
        t2 = temp[1][0]*temp[0][0]+temp[1][1]*temp[1][0]
        t3 = temp[1][0]*temp[0][1]+temp[1][1]*temp[1][1]
        if n%2==0:
            return [[t0%10007, t1%10007], [t2%10007, t3%10007]]
        else:
            temp = [[t0%10007, t1%10007], [t2%10007, t3%10007]]
            t0 = temp[0][0]+temp[0][1]
            t1 = temp[0][0]
            t2 = temp[0][0]
            t3 = temp[1][0]
            return [[t0%10007, t1%10007], [t2%10007, t3%10007]]
print(dc(N)[0][0])