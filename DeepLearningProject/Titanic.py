import numpy as np
import pandas as pd
import matplotlib.pyplot as plt 
import tensorflow as tf
import csv
from pandas import DataFrame, Series

trainFile = pd.read_csv('C:/Users/Playdata/Desktop/DeepLearningProject/data/train.csv')
testFile =  pd.read_csv('C:/Users/Playdata/Desktop/DeepLearningProject/data/test.csv')
answerFile =  pd.read_csv('C:/Users/Playdata/Desktop/DeepLearningProject/data/gender_submission.csv')

trainFrame = DataFrame(trainFile)
testFrame = DataFrame(testFile)
answerFrame = DataFrame(answerFile)
#print(trainFrame)

trainFrame.PassengerId = trainFrame.PassengerId.replace(np.nan,1)
trainFrame.Survived = trainFrame.Survived.replace(np.nan,1)
trainFrame.Pclass = trainFrame.Pclass.replace(np.nan,3)
trainFrame.Name = trainFrame.Name.replace(np.nan,'Unknown')
trainFrame.Sex = trainFrame.Sex.replace(np.nan,'female')
trainFrame.Age = trainFrame.Age.replace(np.nan,20.0)

trainFrame.SibSp = trainFrame.SibSp.replace(np.nan,0)
trainFrame.Parch = trainFrame.Parch.replace(np.nan,0)
del trainFrame['Ticket']

i = 0

print(trainFrame['Age'])
