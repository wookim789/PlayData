import numpy as np
import pandas as pd
import matplotlib.pyplot as plt 
import tensorflow as tf
import csv
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

del trainFrame['PassengerId']
del trainFrame['Survived']
del trainFrame['Ticket']
del trainFrame['Cabin']
#test data 제거 항목
del testFrame['PassengerId']
del testFrame['Ticket']
del testFrame['Cabin']
#testAnswer data 제거 항목
del testAnswerFrame["PassengerId"]

trainFrame.apply(lambda x : 0 if np.isnan(x) else x).fillna(0).astype(int)
print(trainFrame.ix[:,3])
#print(trainFrame.describe())
#print(trainFrame.ix[:,0].value_counts())



# #,Fare,Cabin,Embarked

# testFrame.PassengerId = testFrame.PassengerId.replace(np.nan,1)
# testFrame.Pclass = testFrame.Pclass.replace(np.nan,3)
# testFrame.Sex = testFrame.Sex.replace(np.nan,replaceNanInSex)
# testFrame.Sex = testFrame.Sex.replace('female',0)
# testFrame.Sex = testFrame.Sex.replace('male',1)
# testFrame.Age = testFrame.Age.replace(np.nan,29)
# testFrame.Fare= testFrame.Fare.replace(np.nan,meanFare)
# testFrame.Cabin = testFrame.Cabin.replace(np.nan,"unknown")
# testFrame.SibSp = testFrame.SibSp.replace(np.nan,0)
# testFrame.Parch = testFrame.Parch.replace(np.nan,0)
# testFrame.Embarked = testFrame.Embarked.replace(np.nan,replaceNanInEmvarked)
# testFrame.Embarked = testFrame.Embarked.replace('S',1)
# testFrame.Embarked = testFrame.Embarked.replace('C',2)
# testFrame.Embarked = testFrame.Embarked.replace('Q',3)

# trainAnswerFrame = trainFrame['Survived']

# trainFrame.PassengerId = trainFrame.PassengerId.replace(np.nan,1)
# trainFrame.Survived = trainFrame.Survived.replace(np.nan,1)
# trainFrame.Pclass = trainFrame.Pclass.replace(np.nan,3)
# trainFrame.Sex = trainFrame.Sex.replace(np.nan,replaceNanInSex)
# trainFrame.Sex = trainFrame.Sex.replace('female',0)
# trainFrame.Sex = trainFrame.Sex.replace('male',1)
# trainFrame.Age = trainFrame.Age.replace(np.nan,29)
# trainFrame.Fare= trainFrame.Fare.replace(np.nan,meanFare)
# trainFrame.Cabin = trainFrame.Cabin.replace(np.nan,"unknown")
# trainFrame.SibSp = trainFrame.SibSp.replace(np.nan,0)
# trainFrame.Parch = trainFrame.Parch.replace(np.nan,0)
# trainFrame.Embarked = trainFrame.Embarked.replace(np.nan,replaceNanInEmvarked)
# trainFrame.Embarked = trainFrame.Embarked.replace('S',1)
# trainFrame.Embarked = trainFrame.Embarked.replace('C',2)
# trainFrame.Embarked = trainFrame.Embarked.replace('Q',3)


# #print(trainFrame.ix[:,6])
# #train data 제거 항목


# #keras
# print(trainFrame.shape)
# print(testFrame.shape)
# model = Sequential()
# model.add(Dense(units = 100, input_shape =(8,) , activation = 'relu'))
# model.add(Dropout(0.2))
# #model.add(Dense(units = 60, activation = 'relu'))
# #model.add(Dropout(0.6))
# model.add(Dense(units=1, activation='sigmoid'))

# model.compile(loss='binary_crossentropy',
#               optimizer = 'adam',
#               metrics=['accuracy']
#              )
# model.fit(trainFrame, trainAnswerFrame, epochs=30,  validation_split = 0.2)

# model.evaluate(testFrame, testAnswerFrame)

# predicted_Y = model.predict(testFrame)
# match = predicted_Y == testAnswerFrame
# wrong_label = np.where(predicted_Y>0.5, 1,0)
# cnt = 0

# taf = np.array(testAnswerFile)
# for i in range (wrong_label.shape[0]) :
#     if wrong_label[i] == taf[i] :
#         cnt = cnt + 1
# print("acc : {:d}",  (cnt/wrong_label.shape[0]))