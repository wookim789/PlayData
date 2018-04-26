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
replaceNanInEmvarked = dp.replaceNanInEmvarked1("Embarked")

#,Fare,Cabin,Embarked

trainFrame.PassengerId = trainFrame.PassengerId.replace(np.nan,1)

trainFrame.Survived = trainFrame.Survived.replace(np.nan,1)

trainFrame.Pclass = trainFrame.Pclass.replace(np.nan,3)

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
model.add(Dense(units = 100, input_shape =(8,) , activation = 'relu'))
model.add(Dropout(0.2))
#model.add(Dense(units = 60, activation = 'relu'))
#model.add(Dropout(0.6))
model.add(Dense(units=1, activation='sigmoid'))

model.compile(loss='binary_crossentropy',
              optimizer = 'adam',
              metrics=['accuracy']
             )
model.fit(trainFrame, trainAnswerFrame, epochs=50,  validation_split = 0.2)


#loss_and_metrics = model.evaluate(x_test, y_test, batch_size=128)
#print(trainAnswerFrame)
