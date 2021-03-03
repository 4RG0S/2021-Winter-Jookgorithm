import sys

for _ in range(int(sys.stdin.readline().strip())):
    score = list()
    for _ in range(int(sys.stdin.readline().strip())):
        score.append(list(map(int, sys.stdin.readline().strip().split())))

    score = sorted(score, key=lambda x: x[0])
    cnt = 1
    m = score[0][1]
    for i in range(1, len(score)):
        if score[i][1] < m:
            m = score[i][1]
            cnt += 1
    print(cnt)