import sys
from collections import deque

text = sys.stdin.readline().rstrip('\n')
while text != ".":
    q = deque()
    for i in text:
        try:
            if i == "(":
                q.append(1)
            elif i == ")":
                if q.pop() == 2:
                    q.append(3)
                    break
            elif i == "[":
                q.append(2)
            elif i == "]":
                if q.pop() == 1:
                    q.append(3)
                    break
        except Exception:
            q.append(3)
            break
    if len(q) == 0:
        print("yes")
    else:
        print("no")
    text = sys.stdin.readline().rstrip('\n')