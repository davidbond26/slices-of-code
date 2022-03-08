import turtle
import random
from turtle import Turtle

turtle.colormode(255)
Life: Turtle = turtle.Turtle()
Life.speed(10000)
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
if ans2 == "colors":
    ans = input("What do you want to run? (Red//White/Black/Green/Blue) :")
    if ans == "Red" or ans == "red":
        n = 1
        n1 = 0
        n2 = 0
    if ans == "White" or ans == "white":
        n = 1
        n1 = 1
        n2 = 1
    if ans == "Black" or ans == "black":
        n = -1
        n1 = -1
        n2 = -1
    if ans == "Green" or ans == "green":
        n = 0
        n1 = 1
        n2 = 0
    if ans == "Blue" or ans == "blue":
        n = 0
        n1 = 0
        n2 = 1
if ans2 == "Rand" or ans2 == "rand":
    num4 = random.randint(0, 255)
    num5 = random.randint(0, 255)
    num6 = random.randint(0, 255)
    while num <= 100000:
        Life.color(num4, num5, num6)
        Life.forward(1)
        Life.left(90)
        Life.forward(num2)
        Life.left(90)
        Life.forward(num)
        Life.left(90)
        Life.forward(num)
        Life.left(90)
        Life.forward(num)
        num += 2
        num2 += 2
        num4 = random.randint(0, 255)
        num5 = random.randint(0, 255)
        num6 = random.randint(0, 255)
if ans2 == "colors":
    if ans == "Black":
        col = 255
        col2 = 255
        col3 = 255
    while num3 <= 255:
        Life.color(col, col2, col3)
        Life.forward(1)
        Life.backward(1)
        Life.forward(1)
        Life.left(90)
        Life.forward(num2)
        Life.left(90)
        Life.forward(num)
        Life.left(90)
        Life.forward(num)
        Life.left(90)
        Life.forward(num)
        col += n
        col2 += n1
        col3 += n2
        num += 2
        num2 += 2
        num3 += 1






