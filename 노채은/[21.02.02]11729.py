#BOJ_11729

def move (start,to):
    print(start, to)

def hanoi(N,start,to,via):
    if N == 1:
        move(start,to)
    else:
        hanoi(N-1,start,via,to)
        move(start,to)
        hanoi(N-1,via,to,start)

N = int(input())
print((2**N) - 1)
start = '1'
to = '3'
via = '2'
hanoi(N,start,to,via)
