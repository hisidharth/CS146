from typing import List, Set

class Solution:

    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:

        total_cost = 0

        done = set()

        while len(done) < n:

            lowwell, besthousewell = self.find_min_well(wells, done)

            lowpipe, lowhousepipe = self.find_min_pipe(pipes, done)


            if lowwell < lowpipe:
                done.add(besthousewell)
                total_cost += lowwell

            elif lowpipe < lowwell:

                done.add(lowhousepipe)
                total_cost += lowpipe
            else:

                done.add(lowhousepipe)

                total_cost += lowpipe

        return total_cost
    

    def find_min_well(self, wells: List[int], done: Set[int]) -> int:

        lowwell = float('inf')
        besthousewell = -10


        for i, well in enumerate(wells):
            if i + 1 not in done and well < lowwell:

                lowwell = well

                besthousewell = i + 1
        return lowwell, besthousewell

    def find_min_pipe(self, pipes: List[List[int]], done: Set[int]) -> int:
        lowpipe = float('inf')

        lowhousepipe = -10


        for pipe in pipes:
            if pipe[0] in done and pipe[1] not in done and pipe[2] < lowpipe:
                lowpipe = pipe[2]

            
                lowhousepipe = pipe[1]

            elif pipe[1] in done and pipe[0] not in done and pipe[2] < lowpipe:

                lowpipe = pipe[2]

                lowhousepipe = pipe[0]

        return lowpipe, lowhousepipe

n = 5
wells = [5, 8, 2, 1, 9]

pipes = [[1, 2, 3], [2, 3, 2], [3, 4, 1], [4, 5, 5], [5, 1, 2]]


solution = Solution()
print(solution.minCostToSupplyWater(n, wells, pipes))
