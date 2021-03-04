# IOIOI
N = int(input())
M = int(input())
S = input()
if 2*N+1>M:
    print(0)
else:
    answer = 'IO'*N+'I'
    correct = 0
    i = 0
    while M>=(i+2*N+1):
        if S[i]=='O':
            i += 1
        else:
            if answer==S[i:i+2*N+1]:
                i += 2*N
                correct += 1
                while M>=(i+3) and 'IOI'==S[i:i+3]:
                    i += 2
                    correct += 1
                i += 1
            else:
                i += 1
    print(correct)        
