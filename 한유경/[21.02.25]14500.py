# 테트로미노
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
S = [list(map(int, input().split())) for n in range(N)]
result = 0

# type 1
for m in range(M-3):
    for n in range(N):
        temp = sum(S[n][m:m+4])
        if temp>result:
            result = temp

# type 1 - R
for n in range(N-3):
    for m in range(M):
        temp = sum([S[i][m] for i in range(n, n+4)])
        if temp>result:
            result = temp

# type 2
for n in range(N-1):
    for m in range(M-1):
        temp = sum([sum(S[i][m:m+2]) for i in range(n, n+2)])
        if temp>result:
            result = temp

# type 3
for n in range(N-2):
    for m in range(M-1):
        temp = sum([S[i][m] for i in range(n, n+3)])
        temp += S[n+2][m+1]
        if temp>result:
            result = temp

# type 3 - M
for n in range(N-2):
    for m in range(M-1):
        temp = sum([S[i][m+1] for i in range(n, n+3)])
        temp += S[n+2][m]
        if temp>result:
            result = temp

# type 3 - R
for n in range(N-1):
    for m in range(M-2):
        temp = sum(S[n][m:m+3])
        temp += S[n+1][m]
        if temp>result:
            result = temp

# type 3 - RM
for n in range(N-1):
    for m in range(M-2):
        temp = sum(S[n][m:m+3])
        temp += S[n+1][m+2]
        if temp>result:
            result = temp

# type 3 - RR
for n in range(N-2):
    for m in range(M-1):
        temp = sum([S[i][m+1] for i in range(n, n+3)])
        temp += S[n][m]
        if temp>result:
            result = temp

# type 3 - RRM
for n in range(N-2):
    for m in range(M-1):
        temp = sum([S[i][m] for i in range(n, n+3)])
        temp += S[n][m+1]
        if temp>result:
            result = temp

# type 3 - RRR
for n in range(N-1):
    for m in range(M-2):
        temp = sum(S[n+1][m:m+3])
        temp += S[n][m+2]
        if temp>result:
            result = temp

# type 3 - RRRM
for n in range(N-1):
    for m in range(M-2):
        temp = sum(S[n+1][m:m+3])
        temp += S[n][m]
        if temp>result:
            result = temp

# type 4
for n in range(N-2):
    for m in range(M-1):
        temp = sum([S[i][m] for i in range(n, n+2)])
        temp += sum([S[i][m+1] for i in range(n+1, n+3)])
        if temp>result:
            result = temp

# type 4 - M
for n in range(N-2):
    for m in range(M-1):
        temp = sum([S[i][m+1] for i in range(n, n+2)])
        temp += sum([S[i][m] for i in range(n+1, n+3)])
        if temp>result:
            result = temp

# type 4 - R
for n in range(N-1):
    for m in range(M-2):
        temp = sum(S[n+1][m:m+2])
        temp += sum(S[n][m+1:m+3])
        if temp>result:
            result = temp

# type 4 - RM
for n in range(N-1):
    for m in range(M-2):
        temp = sum(S[n][m:m+2])
        temp += sum(S[n+1][m+1:m+3])
        if temp>result:
            result = temp

# type 5
for n in range(N-1):
    for m in range(M-2):
        temp = sum(S[n][m:m+3])
        temp += S[n+1][m+1]
        if temp>result:
            result = temp

# type 5 - M
for n in range(N-1):
    for m in range(M-2):
        temp = sum(S[n+1][m:m+3])
        temp += S[n][m+1]
        if temp>result:
            result = temp

# type 5 - R
for n in range(N-2):
    for m in range(M-1):
        temp = sum([S[i][m] for i in range(n, n+3)])
        temp += S[n+1][m+1]
        if temp>result:
            result = temp

# type 5 - RM
for n in range(N-2):
    for m in range(M-1):
        temp = sum([S[i][m+1] for i in range(n, n+3)])
        temp += S[n+1][m]
        if temp>result:
            result = temp

print(result)
