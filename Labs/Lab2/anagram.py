def ana(s, t):
    if len(s) != len(t):
        return False

    slist = list(s)
    tlist = list(t)

    slist.sort()
    tlist.sort()

    for i in range(len(slist)):
        if slist[i] != tlist[i]:
            return False

    return True

print(ana("listen", "silent"))  
print(ana("lol", "lmao"))        
     