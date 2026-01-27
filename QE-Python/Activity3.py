# player1 = input("Player 1 : ").lower()
# player2 = input("Player 2 : ").lower()

# if player1 == player2:
#     print("It's a tie!")
# elif player1 == "rock" and player2 == "scissors":
#     print("Rock beats scissors")
# elif player1 == "scissors" and player2 == "paper":
#     print("Scissors beat paper")
# elif player1 == "paper" and player2 == "rock":
#     print("Paper beats rock")
# elif player2 == "rock" and player1 == "scissors":
#     print("Rock beats scissors")
# elif player2 == "scissors" and player1 == "paper":
#     print("Scissors beats paper")
# elif player2 == "paper" and player1 == "rock":
#     print("Paper beats rock")
# else:
#     print("Invalid input!")


player1 = input("Player 1 choice rock paper or scissors: ").lower()
player2 = input("Player 2 choice rock ppaer or scissors: ").lower()

match (player1, player2):
    case (a, b) if a == b:
        print("It's a tie!")

    case ("rock", "scissors") | ("scissors", "paper") | ("paper", "rock"):
        print("Player 1 wins!")

    case ("scissors", "rock") | ("paper", "scissors") | ("rock", "paper"):
        print("Player 2 wins!")

    case _:
        print("Invalid input!")

