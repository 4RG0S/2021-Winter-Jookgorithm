from collections import defaultdict

n = int(input())
m = int(input())

g = defaultdict(list)
for _ in range(m):
    a, b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)

queue = [1]
visited = []
while queue:
    for i in g[queue.pop()]:
        if i not in visited:
            visited.append(i)
            queue.append(i)

print(len(visited) - 1)