def test(matrix):
    vertex = len(matrix)


    list = []

    for vertex in range(vertex):
        neighbors = []
        for neighbor in range(vertex):


            if matrix[vertex][neighbor] == 1:
                neighbors.append(neighbor)

        list.append(neighbors)
    return list