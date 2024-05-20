from typing import List

class test:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
            nums.sort()
            result = []
            seen = set()

            for i in range(len(nums) - 2):
                target = -nums[i]
                seen.clear()

                for j in range(i + 1, len(nums)):
                    complement = target - nums[j]

                    if complement in seen:
                        triplet = [nums[i], complement, nums[j]]
                        result.append(triplet)

                    seen.add(nums[j])

            return list(set(tuple(sorted(triplet)) for triplet in result))

nums = [-1, 0, 1, 2, -1, -4]
test = test()
print(test.threeSum(nums))