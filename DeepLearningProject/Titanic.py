import numpy as np
import pandas as pd
import matplotlib.pyplot as plt 
import tensorflow as tf
import csv
import keras 
import dataProcessClass as dpc
from keras.models import Sequential
from keras.layers import Dense
from keras.layers import Dropout 
from pandas import DataFrame, Series

trainFile = pd.read_csv('C:/Users/Playdata/Desktop/Playdata/PlayData/DeepLearningProject/data/train.csv')
testFile =  pd.read_csv('C:/Users/Playdata/Desktop/Playdata/PlayData/DeepLearningProject/data/test.csv')
testAnswerFile =  pd.read_csv('C:/Users/Playdata/Desktop/Playdata/PlayData/DeepLearningProject/data/gender_submission.csv')

trainFrame = DataFrame(trainFile)
testFrame = DataFrame(testFile)
testAnswerFrame = DataFrame(testAnswerFile)
#print(trainFrame)

dp = dpc.dataProcess(trainFrame)

MeanAge = dp.avgMethod("Age")
replaceNanInSex = dp.replaceNanInSex("Sex")
meanFare = dp.avgMethod("Fare")
replaceNanInEmvarked = dp.replaceNanInEmbarked1("Emvarked")
#countNum =0
#countS=0
#countQ=0
#countC=0
#replaceNanInEmvarked =''
#nanRow = pd.isna(trainFrame["Embarked"])
#for i in range(trainFrame.shape[0]):
   #print(trainFrame.ix[i,2])
 #   if nanRow[i] == False:
  #      countNum = countNum + 1
   #     if trainFrame.ix[i,11] == 'S':
    #        countS =countS +1
     #   if trainFrame.ix[i,11] == 'Q':
      #      countS =countQ +1
       # if trainFrame.ix[i,11] == 'C':
        #    countS =countC +1
#if countS >countQ :
 #   if countS > countC :
  #      replaceNanInEmvarked = 1
   # else :
    #     replaceNanInEmvarked = 2
#elif countQ > countC:
 #    replaceNanInEmvarked = 3
#else :
 #    replaceNanInEmvarked = 2

#,Fare,Cabin,Embarked

trainFrame.PassengerId = trainFrame.PassengerId.replace(np.nan,1)
trainFrame.Survived = trainFrame.Survived.replace(np.nan,1)
trainFrame.Pclass = trainFrame.Pclass.replace(np.nan,3)
#trainFrame.Name = trainFrame.Name.replace(np.nan,"unknown")
trainFrame.Sex = trainFrame.Sex.replace(np.nan,replaceNanInSex)
trainFrame.Sex = trainFrame.Sex.replace('female',0)
trainFrame.Sex = trainFrame.Sex.replace('male',1)

trainFrame.Age = trainFrame.Age.replace(np.nan,29)
trainFrame.Fare= trainFrame.Fare.replace(np.nan,meanFare)
trainFrame.Cabin = trainFrame.Cabin.replace(np.nan,"unknown")
trainFrame.SibSp = trainFrame.SibSp.replace(np.nan,0)
trainFrame.Parch = trainFrame.Parch.replace(np.nan,0)
trainFrame.Embarked = trainFrame.Embarked.replace(np.nan,replaceNanInEmvarked)
trainFrame.Embarked = trainFrame.Embarked.replace('S',1)
trainFrame.Embarked = trainFrame.Embarked.replace('C',2)
trainFrame.Embarked = trainFrame.Embarked.replace('Q',3)


trainAnswerFrame = trainFrame['Survived']
#print(trainFrame.ix[:,6])

del trainFrame['Survived']
del trainFrame['Ticket']
del trainFrame['Name']
del trainFrame['Cabin']

#keras
print(trainFrame.shape)
model = Sequential()
model.add(Dense(units = 30, input_shape =(8,) , activation = 'relu'))
model.add(Dropout(0.5))
model.add(Dense(units = 60, activation = 'relu'))
model.add(Dropout(0.5))
model.add(Dense(units=1, activation='sigmoid'))

model.compile(loss='binary_crossentropy',
              optimizer = 'adam',
              metrics=['accuracy']
             )
model.fit(trainFrame, trainAnswerFrame, epochs=10,  validation_split = 0.2)


#loss_and_metrics = model.evaluate(x_test, y_test, batch_size=128)
#print(trainAnswerFrame)
