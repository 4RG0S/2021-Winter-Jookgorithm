time = list()
for _ in range(int(input())):
    time.append(list(map(int, input().split())))

time = sorted(time, key=lambda x: (x[1], x[0]))

end = 0
count = 0
for s, t in time:
    if s >= end:
        count += 1
        end = t
print(count)