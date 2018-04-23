import numpy as np
import pandas as pd

class dataProcess :
    def __init__(self,arr):
        self.dataFrame = arr
        

    def avgMethod (self,colName):
        sumNum = 0
        countNum = 0
        nanCol = pd.isna(self.dataFrame[colName])

        for i in range(nanCol.shape[0]):
            if nanCol[i] == False: #배열에 값이 있으면
                sumNum = sumNum + self.dataFrame.ix[i,colName]
                countNum = countNum + 1
        print("done1")       
        return(sumNum / countNum) # 평균값 반환
    
    def replaceNanInSex (self,colName):
        nanCol = pd.isna(self.dataFrame[colName])
        countAllNum = 0
        countfemale = 0

        for i in range(nanCol.shape[0]):
            if nanCol[i] == False: #배열에 값이 있으면
                countAllNum = countAllNum + 1
                if self.dataFrame.ix[i,colName] == 'female':
                    countfemale = countfemale + 1
        countmale = countAllNum - countfemale    
        if countmale > countfemale :
            print("done2")  
            return(1)
        else :
            print("done2") 
            return(0)
        return("Can't")

    def replaceNanInEmvarked1(self,colName):
        nanCol = pd.isna(self.dataFrame[colName])
        countAllNum = 0
        countS =0
        countQ =0
        countC =0
        for i in range(self.dataFrame.shape[0]):
        #print(trainFrame.ix[i,2])
            if nanCol[i] == False:
                countAllNum = countAllNum + 1
            if self.dataFrame.ix[i,colName] == 'S':
                countS =countS +1
            if self.dataFrame.ix[i,colName] == 'Q':
                countQ =countQ +1
            if self.dataFrame.ix[i,colName] == 'C':
                countC =countC +1
        if countS >countQ :
            if countS > countC :
                replaceNanInEmvarked = 1
            else :
                replaceNanInEmvarked = 2
        elif countQ > countC:
            replaceNanInEmvarked = 3
        else :
            replaceNanInEmvarked = 2
        return (replaceNanInEmvarked)