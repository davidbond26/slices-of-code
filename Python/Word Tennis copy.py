import random
import time

states = ["Alabama", "Arizona", "Alaska", "Arkansas", "California", "Colorado", "Hawaii", "Connecticut", "Delaware",
          "Florida", "Georgia", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine",
          "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska",
          "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
          "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas",
          "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"]
number1 = 49
number2 = random.randint(0, number1)
score = 0
print("Welcome to word tennis!!!!")
time.sleep(2)
print("The category is: The 50 States!")
time.sleep(2)
print("I'll go first:")
time.sleep(2)
while number1 <= 49:
    print(states[number2])
    time.sleep(2)
    states.remove(states[number2])
    number1 -= 1
    number2 = random.randint(0, number1)
    answer = input("Now you give a state:")
    score += 1
    if answer not in states:
        print("Sorry, you lose. Your score was: " + str(score))
        quit()
    if answer in states:
        print("good job!")
        number1 -= 1
        time.sleep(2)
        score += 1
        states.remove(answer)
print("you have guessed every state. Congratulations. Your score was 50.")
