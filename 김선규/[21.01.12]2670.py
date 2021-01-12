import sys

def main():
    n = int(sys.stdin.readline())
    li = [float(sys.stdin.readline()) for _ in range(n)]
    
    m = li[0]
    for i in range(1, n):
        li[i] = max(li[i], li[i] * li[i-1])
        m = max(m, li[i])
    print(format(m, ".3f"))

if __name__ == "__main__":
    main()