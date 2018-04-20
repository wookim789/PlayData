import numpy as np
import pandas as pd
import matplotlib.pyplot as plt 
import tensorflow as tf
import csv
from pandas import DataFrame, Series

trainFile = pd.read_csv('C:/Users/Playdata/Desktop/Playdata/PlayData/DeepLearningProject/data/train.csv')
testFile =  pd.read_csv('C:/Users/Playdata/Desktop/Playdata/PlayData/DeepLearningProject/data/test.csv')
answerFile =  pd.read_csv('C:/Users/Playdata/Desktop/Playdata/PlayData/DeepLearningProject/data/gender_submission.csv')

trainFrame = DataFrame(trainFile)
testFrame = DataFrame(testFile)
answerFrame = DataFrame(answerFile)
#print(trainFrame)

sumAge = 0
countNum = 0
MeanAge=0

nanRow = pd.isna(trainFrame["Age"])
for i in range(trainFrame.shape[0]):
   #print(trainFrame.ix[i,2])
    if nanRow[i]== False:
         sumAge += trainFrame.ix[i,5]
         countNum = countNum + 1
meanAge = sumAge / countNum


countfemale = 0
countNum = 0

nanRow = pd.isna(trainFrame["Sex"])
for i in range(trainFrame.shape[0]):
    if nanRow[i] == False:
         countNum = countNum + 1
         if trainFrame.ix[i,4] == 'female':
             countfemale = countfemale + 1
countmale = countNum - countfemale

replaceNanInSex =""
if countmale > countfemale :
    replaceNanInSex = 'male'
else :
    replaceNanInSex = 'female'

trainFrame.PassengerId = trainFrame.PassengerId.replace(np.nan,1)
trainFrame.Survived = trainFrame.Survived.replace(np.nan,1)
trainFrame.Pclass = trainFrame.Pclass.replace(np.nan,3)
trainFrame.Name = trainFrame.Name.replace(np.nan,'Unknown')
trainFrame.Sex = trainFrame.Sex.replace(np.nan,replaceNanInSex)
trainFrame.Age = trainFrame.Age.replace(np.nan,meanAge)

trainFrame.SibSp = trainFrame.SibSp.replace(np.nan,0)
trainFrame.Parch = trainFrame.Parch.replace(np.nan,0)
del trainFrame['Ticket']
del trainFrame['Survived']

i = 0

print(trainFrame)
