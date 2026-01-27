def sum_of_list(lst):
    sum= 0
    for num in lst:
        sum += num
    return sum

numbers = list(map(int, input("Enter numbers: ").split()))
print("Sum is: ", sum_of_list(numbers))
