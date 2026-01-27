#nested loop
n = int(input("Enter the number of rows: "))
for i in range(1, n + 1):
    for j in range(i):
        print(i, end="")
    print()
#single loop   
n=int(input("Enter number of rows: "))
for i in range(n):
    print(str(i)*i)
#single loop ..single line
n=int(input("Enter number of rows: "))
for i in range(n):
    print(str(i)*i,end=" ")
