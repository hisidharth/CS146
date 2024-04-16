from collections import defaultdict, deque

def canFinish(numCourses, prerequisites):
    inDegree = defaultdict(int)
    for i in range(numCourses):
        inDegree[i] = 0
    
    for prerequisite in prerequisites:
        course = prerequisite[0]
        inDegree[course] += 1
    
    queue = deque()
    for i in range(numCourses):
        if inDegree[i] == 0:
            queue.append(i)
    
    count = 0
    while queue:
        node = queue.popleft()
        for prerequisite in prerequisites:
            if prerequisite[1] == node:
                course = prerequisite[0]
                inDegree[course] -= 1
                if inDegree[course] == 0:
                    queue.append(course)
        count += 1
    
    return count == numCourses

if __name__ == "__main__":
    

    numCourses1 = 5
    prerequisites1 = []
    print("Test Case 1 (Empty prerequisites):", canFinish(numCourses1, prerequisites1))

    numCourses2 = 1
    prerequisites2 = []
    print("Test Case 2 (Single course):", canFinish(numCourses2, prerequisites2))

    numCourses3 = 1
    prerequisites3 = [[1, 0], [2, 1], [3, 2]]
    print("Test Case 3 (Linear prerequisites):", canFinish(numCourses3, prerequisites3))

    numCourses4 = 3
    prerequisites4 = [[0, 1], [1, 2], [2, 0]]
    print("Test Case 4 (Circular prerequisites):", canFinish(numCourses4, prerequisites4))

    numCourses5 = 3
    prerequisites5 = [[1, 0], [2, 0], [2, 1]]
    print("Test Case 5 (All courses have prerequisites):", canFinish(numCourses5, prerequisites5))

    numCourses6 = 3
    prerequisites6 = []
    print("Test Case 6 (No prerequisites):", canFinish(numCourses6, prerequisites6)) 
