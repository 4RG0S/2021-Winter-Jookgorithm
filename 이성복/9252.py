def solution(string1, string2):
    lcs = [[0 for i in range(len(string1))] for j in range(len(string2))]

    for i in range(1, len(string2)):
        for j in range(1, len(string1)):
            if string2[i] == string1[j]:
                lcs[i][j] = lcs[i - 1][j - 1] + 1
            else:
                lcs[i][j] = max(lcs[i][j - 1], lcs[i - 1][j])

    lcs_length = max(lcs[-1])
    tmp1 = lcs_length
    tmp0 = tmp1 - 1
    for_j = len(string1) - 1

    result = ''
    for i in range(len(string2) - 1, 0, -1):
        for j in range(for_j, 0, - 1):
            if lcs[i][j] == tmp1 and lcs[i][j - 1] == tmp0 and lcs[i - 1][j - 1] == tmp0 and lcs[i - 1][j] == tmp0:
                tmp0 -= 1
                tmp1 -= 1
                result = string2[i] + result
                for_j = j
                break
    return lcs_length, result


if __name__ == '__main__':
    s1 = 'a' + str(input())
    s2 = 'a' + str(input())
    lcs_length, lcs = solution(s1, s2)
    print(lcs_length)
    print(lcs)