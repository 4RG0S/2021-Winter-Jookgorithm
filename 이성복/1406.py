# import sys
#
# input = sys.stdin.readline
#
# sentence = input()
# cursor = len(sentence)
#
# for _ in range(int(input())):
#     command = list(input().split())
#
#     if command[0] == 'L':   # move cursor to the left
#         cursor -= 1
#         if cursor < 0:
#             cursor = 0
#     elif command[0] == 'D': # move cursor to the right
#         cursor += 1
#         if cursor > len(sentence):
#             cursor = len(sentence)
#     elif command[0] == 'B': # delete char left side of the cursor
#         if cursor == 0:
#             continue
#         sentence = sentence[:cursor - 1] + sentence[cursor:]
#         cursor -= 1
#     elif command[0] == 'P': # insert char left side of the cursor
#         if cursor == 0:
#             sentence = command[1] + sentence
#             cursor += 1
#             continue
#         sentence = sentence[:cursor] + command[1] + sentence[cursor:]
#         cursor += 1
#
# print(sentence)

import sys
from collections import deque

input = sys.stdin.readline

sentence = list(input().rstrip())
left_sentence = deque(sentence)
right_sentence = deque()

for _ in range(int(input())):
    command = list(input().split())

    if command[0] == 'L':   # move cursor to the left
        if left_sentence:
            right_sentence.appendleft(left_sentence.pop())
    elif command[0] == 'D': # move cursor to the right
        if right_sentence:
            left_sentence.append(right_sentence.popleft())
    elif command[0] == 'B': # delete char left side of the cursor
        if left_sentence:
            left_sentence.pop()
    elif command[0] == 'P': # insert char left side of the cursor
        left_sentence.append(command[1])

print(''.join(left_sentence) + ''.join(right_sentence))