def reverse(graph):

    reverseddictionary = {}
    for vertex, neighbors in graph.items():


        for neighbor in neighbors:
           
            if neighbor not in reverseddictionary:
                reverseddictionary[neighbor] = []

            reverseddictionary[neighbor].append(vertex)
    return reverseddictionary

