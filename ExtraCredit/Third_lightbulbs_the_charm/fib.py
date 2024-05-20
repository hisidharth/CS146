def fibo(val):
    prev = 0
    next = 1

    for i in range(val):
        temp = prev + next
        prev = next 
        next = temp
    return prev

print(fibo(10))