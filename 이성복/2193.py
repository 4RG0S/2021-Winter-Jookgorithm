n = int(input())

f = list()
f.append(1)
f.append(1)

for i in range(2, 91):
    f.append(f[i-1] + f[i-2])

print(f[n - 1])