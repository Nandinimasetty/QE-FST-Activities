def fibonacci(n):
    n1=0
    n2=1
    count=0
    if n<=0:
        print("Invalid number")
    elif n==1:
        print("Fibonacci sequence is: ")
        print(n1)
    else:
        print("Fibonacci sequence is: ")
        while count<n:
            print(n1)
            nth=n1+n2
            n1=n2
            n2=nth
            count+=1
n=int(input("Enter a number: "))
(fibonacci(n))
