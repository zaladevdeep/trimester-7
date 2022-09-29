# gradient descent with regularization

import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
import math
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn import linear_model


df = pd.read_csv('CSI0702 Machine Learning\Real_Estate_Prices.csv')

print(df)

x=df.drop(['No','Y house price of unit area'],axis=1)

y=df['Y house price of unit area']

x=np.array(df.drop(['No','Y house price of unit area'],axis=1))
y=np.array(df['Y house price of unit area']).reshape(-1,1)

lr = LinearRegression()

lr.fit(x,y)

lr.coef_

lr.intercept_

yp=lr.predict(x)

def RSE(y,yp):
    y=np.array(y)
    yp=np.array(yp)
    RSS=np.sum(np.square(y-yp))
    rse=math.sqrt(RSS/(len(y)-2))
    
    return rse

rse=RSE(y,yp)

print(rse)

train_x,test_x,train_y,test_y=train_test_split(x,y,test_size=0.3,random_state=2)

reg = LinearRegression().fit(train_x,train_y)

print(reg.score(test_x,test_y))

print(reg.score(train_x,train_y))

lasso_reg = linear_model.Lasso(alpha=0.001,max_iter=10000,tol=0.1)

lasso_reg.fit(train_x,train_y)

print(lasso_reg.score(test_x,test_y))

print(lasso_reg.score(train_x,train_y))