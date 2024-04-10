def test(list):
    vertex = len(list)
    matrix = [[0] * vertex for _ in range(vertex)]
    
    for vertex, neighbors in enumerate(list):


        for neighbor in neighbors:
 
            matrix[vertex][neighbor] = 1
    
    return matrix
