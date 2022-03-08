import curses
import random

s = curses.initscr()
curses.curs_set(0)
sh, sw = s.curses.getmaxyx()
w = curses.newwin(sh, sw, 0, 0)
w.keypad(1)
w.timeout(100)




