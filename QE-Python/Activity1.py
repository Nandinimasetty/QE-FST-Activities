from datetime import datetime
name=input("Enter name: ")
print("Name is: " +name)
age=int(input("Enter age: "))
print(f"Age is: {age}.")
current_year=datetime.now().year
year_turn_100=current_year+(100-age)
print(f"You will turn 100 years old in the year {year_turn_100}.")