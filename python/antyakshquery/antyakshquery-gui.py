#!/usr/bin/python3

import random
import sys
import tkinter as Tk
from tkinter import messagebox
from tkinter import filedialog

class MyGui(Tk.Frame):
  def __init__(self, master, participantsFile, topicsFile):
    Tk.Frame.__init__(self, master)
    self.grid()
    self.btnnext = Tk.Button(self, text="Next", command=self.next)
    self.btnnext.grid()
    self.btnpass = Tk.Button(self, text="Pass", command=self.doPass)
    self.btnpass.grid()
    self.lparticipant = Tk.Label(self)
    self.lparticipant.grid()
    self.ltopic = Tk.Label(self)
    self.ltopic.grid()

    self.topics = MyGui.readFile(topicsFile)
    self.participants = MyGui.readFile(participantsFile)
    for topic in self.topics:
      print("\t", topic)
    self.remainingTopics = self.topics[:]

  @staticmethod
  def readFile(fname):
    with open(fname, "r") as fin:
      lines = fin.readlines()
      lines = [line.strip() for line in lines]
      return lines

  def nextParticipant(self):
    participantNum = random.randint(0, len(self.participants) - 1)
    return self.participants[participantNum]

  def nextTopic(self):
    topicNum = random.randint(0, len(self.remainingTopics) - 1)
    return self.remainingTopics[topicNum]

  def doPass(self):
    participant = self.nextParticipant()
    self.lparticipant.config(text = participant, fg='blue', font=("Helvetica", 16) )

  def next(self):
    if(self.remainingTopics == []):
      messagebox.showinfo("Antyakshquery", "All Topics Over! Good Bye!")
      sys.exit(0)
    participant = self.nextParticipant()
    self.lparticipant.config(text = participant, fg='blue', font=("Helvetica", 16) )

    topic = self.nextTopic()
    self.remainingTopics.remove(topic)
    self.ltopic.config(text = topic, fg='red', font=("Helvetica", 16))

if __name__ == "__main__":
  participantsFile = "participants.txt"
  topicsFile = "topics.txt"
  if(len(sys.argv) > 1 and sys.argv[1] == "-i"):
    participantsFile = filedialog.askopenfilename(initialdir = ".",title = "Select Participants file")
    topicsFile = filedialog.askopenfilename(initialdir = ".",title = "Select Topics file")
    print("Participants file : ", participantsFile)
    print("Topics file : ", topicsFile)

  root = Tk.Tk()
  root.title("Antyakshquery")
  root.geometry("300x200")
  gui = MyGui(root, participantsFile = participantsFile, topicsFile = topicsFile)
  gui.grid()
  root.mainloop()
 
