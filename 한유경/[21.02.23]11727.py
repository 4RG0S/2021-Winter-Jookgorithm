N = int(input())
cnt = [1]*1001
for i in range(2, 1001):
	cnt[i] = cnt[i-1]*i
M = [0]*3
M[0] = N
result = 1
while M[0]-2>=0:
	M[0] -= 2
	M[1] += 1
	result += cnt[M[0]+M[1]]//(cnt[M[0]]*cnt[M[1]])
	M[2] = M[1]
	M[1] = 0
	result %= 10007
	while M[2]>0:
		result += cnt[M[0]+M[1]+M[2]]//(cnt[M[0]]*cnt[M[1]]*cnt[M[2]])
		M[2] -= 1
		M[1] += 1
		result %= 10007

print(result%10007)
