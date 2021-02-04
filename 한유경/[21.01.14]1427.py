# 소트인사이드
import sys
input = sys.stdin.readline

N = sorted(list(input()))
print(''.join(N[::-1]))