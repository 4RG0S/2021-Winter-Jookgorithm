# 그룹 단어 체커
N = int(input())
result = N
for a in range(N):
    _input = input()
    alphabet = []
    i = 0
    while i<len(_input):
        if _input[i] not in alphabet:
            temp = _input[i]
            while _input[i]==temp:
                i += 1
                if i>=len(_input):
                    break
            alphabet.append(temp)
        else:
            result -= 1
            break
print(result)