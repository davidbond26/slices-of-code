import turtle
import random

num4 = random.randint(0, 255)
num5 = random.randint(0, 255)
num6 = random.randint(0, 255)
num = 1
y = 0
turtle.colormode(255)
Life = turtle.Turtle()
Life.speed(1000000)
Life.shape('turtle')

num3 = 0
num2 = 1
num = 2
n = 0
n1 = 0
n2 = 0
ans2 = input("colors or rand? :")
col = 0
col2 = 0
col3 = 0
ans = ""
if ans2 == "colors":
    ans = input("What do you want to run? (Red//White/Black/Green/Blue) :")

if ans == "Red":
    n = 1
    n1 = 0
    n2 = 0
if ans == "White":
    n = 1
    n1 = 1
    n2 = 1
if ans == "Black":
    n = -1
    n1 = -1
    n2 = -1
if ans == "Green":
    n = 0
    n1 = 1
    n2 = 0
if ans == "Blue":
    n = 0
    n1 = 0
    n2 = 1
if ans == "Black":
    col = 255
    col2 = 255
    col3 = 255
if ans2 == "colors":
    while num3 <= 255:
        Life.color(col, col2, col3)
        Life.circle(num)
        Life.sety(y)
        col += n
        col2 += n1
        col3 += n2
        num += 1
        y += -1

if ans2 == "rand":
    turtle.colormode(255)
    Life = turtle.Turtle()
    Life.speed(1000000)
    Life.shape('turtle')
    while num <= 100000:
        Life.color(num4, num5, num6)
        Life.circle(num)
        Life.sety(y)
        num4 = random.randint(0, 255)
        num5 = random.randint(0, 255)
        num6 = random.randint(0, 255)
        num += 1
        y += -1



