while True:
    player1 = input("Player 1 choice rock paper or scissors: ").lower()
    player2 = input("Player 2 choice rock paper or scissors: ").lower()

    match (player1, player2):
        case (a, b) if a == b:
            print("It's a tie!")

        case ("rock", "scissors") | ("scissors", "paper") | ("paper", "rock"):
            print("Player 1 wins!")

        case ("scissors", "rock") | ("paper", "scissors") | ("rock", "paper"):
            print("Player 2 wins!")

        case _:
            print("Invalid input!")

    choice = input("\nDo you want to play next round? (yes/no): ").lower()
    if choice != "yes":
        print("Game exited. Thanks for playing!")
        break
