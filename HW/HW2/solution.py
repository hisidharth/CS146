def firstBadVersion(n, versions):
    left = 1
    right = n

    while left < right:
        mid = left + (right - left) // 2
        if isBadVersion(versions[mid - 1]):  
            right = mid
        else:
            left = mid + 1

    return left  

def isBadVersion(version):
    return version > 5

n = 10
versions = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
print(firstBadVersion(n, versions))
