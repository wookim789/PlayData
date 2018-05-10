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

trainAnswerFrame = trainFrame['Survived']

del trainFrame['PassengerId']
del trainFrame['Survived']
del trainFrame['Ticket']
del trainFrame['Cabin']
#test data 제거 항목
del testFrame['PassengerId']
del testFrame['Ticket']
del testFrame['Cabin']
#testAnswer data 제거 항목
del testAnswerFrame["Survived"]


trainFrame = trainFrame.replace(np.nan,0)

sex = lambda x : 0 if x == 'male' else 1
age = lambda x : 0.7 if x == 0 else 1 if x <= 19 else 0.5 if x <= 30 else 0.3 if x <=50 else 0.8
pclass = lambda x : 0 if x == 3 else 0.5 if x == 2 else 1
fare = lambda x : x / 512.
embarked = lambda x : 1 if x =='S'  else 0.7 if x =='Q'  else 0.5
name = lambda x : 0 if 'Mr.' in x else 0.5 if 'Dr.' in x else 0.6 if  'Master.'in x  else 0.8 if ('Mrs.' in x )or('Miss' in x )or ('Lady' in x )or('Ms' in x) else 0 
sibsp = lambda x : x / 8 
print(trainFrame.describe())
#print(trainFrame.ix[:,0].value_counts())
# #,Fare,Cabin,Embarked


trainFrame.Pclass = trainFrame.Pclass.apply(pclass)
trainFrame.Sex = trainFrame.Sex.apply(sex)
trainFrame.Age = trainFrame.Age.apply(age)
trainFrame.Fare= trainFrame.Fare.apply(fare)
trainFrame.Embarked = trainFrame.Embarked.apply(embarked) 
trainFrame.Name = trainFrame.Name.apply(name)
trainFrame.SibSp = trainFrame.SibSp.apply(sibsp)

testFrame.Pclass = testFrame.Pclass.apply(pclass)
testFrame.Sex = testFrame.Sex.apply(sex)
testFrame.Age = testFrame.Age.apply(age)
testFrame.Fare= testFrame.Fare.apply(fare)
testFrame.Embarked = testFrame.Embarked.apply(embarked)
testFrame.Name = testFrame.Name.apply(name)
testFrame.SibSp = testFrame.SibSp.apply(sibsp)

print(trainFrame)
# #print(trainFrame.ix[:,6])
# #train data 제거 항목

#keras
# print(trainFrame.shape)
# print(testFrame.shape)
model = Sequential()
model.add(Dense(units = 200, input_shape =(8,) , activation = 'relu'))
model.add(Dropout(0.2))
model.add(Dense(units = 200, input_shape =(8,) , activation = 'relu'))
model.add(Dropout(0.2))
model.add(Dense(units = 100, input_shape =(8,) , activation = 'relu'))
model.add(Dropout(0.2))
model.add(Dense(units = 100, input_shape =(8,) , activation = 'relu'))
model.add(Dropout(0.2))
model.add(Dense(units = 50, input_shape =(8,) , activation = 'relu'))
model.add(Dropout(0.2))
model.add(Dense(units=1, activation='sigmoid'))

model.compile(loss='binary_crossentropy',
               optimizer = 'adam',
               metrics=['accuracy']
              )
model.fit(trainFrame, trainAnswerFrame, epochs = 30 ,  validation_split = 0)

model.evaluate(testFrame, testAnswerFrame)
model.summary()
predicted_Y = model.predict(testFrame.as_matrix())

match = predicted_Y == testAnswerFrame

wrong_label = np.where(predicted_Y>0.5, 1,0)

testAnswerFrame["Survived"] = wrong_label

#print(testAnswerFrame)
# del testAnswerFrame[""]
testAnswerFrame.to_csv("C:/Users/Playdata/Desktop/gender_submission.csv",index = False)

# wrong_label.colums[0] : "PassengerId"
# wrong_label.colums[1] : "Survived"
print(pd.read_csv("C:/Users/Playdata/Desktop/gender_submission.csv"))



# cnt = 0

# taf = np.array(testAnswerFile)
# for i in range (wrong_label.shape[0]) :
#     if wrong_label[i] == taf[i] :
#         cnt = cnt + 1
# print("acc : {:d}",  (cnt/wrong_label.shape[0]))    