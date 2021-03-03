import sys

n = input()

stack = list()

for c in n:
    if c == '(' or c == '[':
        stack.append(c)
    elif c == ')':
        tmp = 0
        while stack:
            t = stack.pop()
            if t == '(':
                if tmp == 0:
                    stack.append(2)
                else:
                    stack.append(2 * tmp)
                break
            elif t == '[':
                print(0)
                sys.exit(0)
            else:
                tmp += t
    elif c == ']':
        tmp = 0
        while stack:
            t = stack.pop()
            if t == '[':
                if tmp == 0:
                    stack.append(3)
                else:
                    stack.append(3 * tmp)
                break
            elif t == '(':
                print(0)
                sys.exit(0)
            else:
                tmp += t

try:
    result = 0
    for i in stack:
        result += i
    print(result)
except:
    print(0)