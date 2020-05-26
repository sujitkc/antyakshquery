This repository contains two implementations -- one in Java and the other 
in Python -- of a Class Fun Quiz game, that I have been using in various
courses I teach.


ANTYAKSHQUERY
-------------
Antyakshari (अंत्याक्षरी) is a popular party game
played in India. Each participant has to sing a song starting with the
last letter of the song sung by the previous participant. Variant involve
naming geographical locations, political leaders etc. based on the general
interest of the participants. The turns go in a round-robin fashion. 
Typically played in a non-competitive way, the game is played in a
competitive mode too.

Antyakshquery is derived from antyakshari replacing akshari with query
to indicate a form of a quiz. (I don't claim orginality of this name. I
picked it from one of my colleagues.)

Typically, on the last lecture of a course I am teaching, I do a
revision in a form of this game. The game is that, one each turn, it
flashes a randomly picked participant name and a topic name covered
during the course. The named person has to explain the given topic in
brief (typically a couple of sentences) to the rest of the class. The
game continues while there are more topics in the list. The game ends
once the list gets exhausted. There's no points or score. No winners or
losers. The topics get covered systematically, the random call of names
brings in that element of suspense. There are laughters and pranks.

Generally, it's good fun!

USAGE
-----
As of now, the application can be launched as:
  ./antyakshquery -i

On this, the program asks for the files used as the participant list
and the topic list respectively. The games starts after that.

If the command line argument '-i' is left out, the program picks up
the default files 'participants.txt' and 'topics.txt' in the current
directory. If these are not found, the program terminates.
