# 종이의 개수
import sys
input = sys.stdin.readline

N = int(input())
paper = [list(input().strip().split()) for i in range(N)]

def dp(n, x, y):
	result = [0]*3
	if n==1:
		result[int(paper[x][y])+1] = 1
		return result
	_x = [x,x,x,x+n//3,x+n//3,x+n//3,x+2*(n//3),x+2*(n//3),x+2*(n//3)]
	_y = [y,y+n//3,y+2*(n//3),y,y+n//3,y+2*(n//3),y,y+n//3,y+2*(n//3)]
	for i in range(9):
		temp = dp(n//3, _x[i], _y[i])
		for k in range(3):
			result[k] += temp[k]
	if result[0]==0 and result[1]==0:
		result[2] = 1
	elif result[0]==0 and result[2]==0:
		result[1] = 1
	elif result[1]==0 and result[2]==0:
		result[0] = 1
	return result
result = dp(N, 0, 0)
for index in result:
	print(index)
