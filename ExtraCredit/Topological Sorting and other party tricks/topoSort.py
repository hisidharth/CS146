from collections import deque

def khan(numNodes, adjacent):
    inDegree = [0] * numNodes

    for i in range(numNodes):
        for x in adjacent[i]:
            inDegree[x] += 1
    
    queue = []

    for i in range(numNodes):
        if inDegree[i] == 0:
            queue.append(i)
    
    temp = [0] * numNodes
    i = 0
    while queue:
        node = queue.pop(0)
        temp[i] = node
        i += 1

        for x in adjacent[node]:
            inDegree[x] -= 1
            if inDegree[x] == 0:
                queue.append(x)

    print("Kahn's Algorithm Topological order:", end=" ")
    for i in range(numNodes):
        print(temp[i], end=" ")
    print()

def bfs(numNodes, adjacent):
    temp = [0] * numNodes
    inDegree = [0] * numNodes
    
    for i in range(numNodes):
        for x in adjacent[i]:
            inDegree[x] += 1
    
    q = deque()
    for i in range(numNodes):
        if inDegree[i] == 0:
            q.append(i)
    
    counter = 0
    index = 0
    
    while q:
        node = q.popleft()
        temp[index] = node
        index += 1
        counter += 1
        for x in adjacent[node]:
            inDegree[x] -= 1
            if inDegree[x] == 0:
                q.append(x)

    print("BFS Topological order:", end=" ")
    for i in range(numNodes):
        print(temp[i], end=" ")
    print()
    
    if counter == numNodes:
        return False
    return True

def dfsHelper(node, adjacent, visited, stack):
    visited[node] = True

    for neighbor in adjacent[node]:
        if not visited[neighbor]:
            dfsHelper(neighbor, adjacent, visited, stack)

    stack.append(node)

def dfs(numNodes, adjacent):
    stack = []
    visited = [False] * numNodes

    for i in range(numNodes):
        if not visited[i]:
            dfsHelper(i, adjacent, visited, stack)

    print("DFS Topological order:", end=" ")
    while stack:
        print(stack.pop(), end=" ")
    print()


def test():
    numNodes = 6
    adjacent = [
        [1, 2],
        [3],
        [3, 4],
        [],
        [5],
        []
    ]

    khan(numNodes, adjacent)
    bfs(numNodes, adjacent)
    dfs(numNodes, adjacent)

if __name__ == "__main__":
    test()
