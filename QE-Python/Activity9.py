n1= list(map(int, input().split()))
n2= list(map(int, input().split()))
n3=[x for x in n1 if x % 2 != 0] + [y for y in n2 if y % 2 == 0]
print(n3)

