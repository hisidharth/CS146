import heapq

class Server:
     def minMeetingRooms(self, intervals):

        min_heap = []

        heapq.heappush(min_heap, intervals[0][1])
        
        for i in range(1, len(intervals)):
            start, end = intervals[i]

            if start >= min_heap[0]:
                heapq.heappop(min_heap)

            heapq.heappush(min_heap, end)
            
        return len(min_heap)



server = Server()
intervals = [[10, 90], [1, 2], [2, 3]]
print(server.minMeetingRooms(intervals))
