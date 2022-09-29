import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.preprocessing import StandardScaler

df=pd.read_csv('CSI0702 Machine Learning\Real_Estate_Prices.csv')

print(df)

df['No']=1

print(df)

scaler=StandardScaler()
data=scaler.fit_transform(df)
data=pd.DataFrame(data)
print(data)
data.iloc[:,0]=1
print(data)
x = data.iloc[0:,0:7]
y=data.iloc[0:,7]
print(y)
x=np.array(x)
y=np.array(y)
cp=[]
itr=[]

def cost(data,params):
    total_cost=0
    for i in range(414):
        total_cost += (1/414)*((data[i]*params).sum() - y[i])**2
    cp.append(total_cost)
    return total_cost    

def gd(data,params,lrate,iter_value):
    for i in range(iter_value):
        itr.append(i)
        slopes = np.zeros(7)
        for j in range(414):
            for k in range(7):
                slopes[k] += (1/414)*((data[j]*params).sum() - y[j])*data[j][k]
        params = params - lrate*slopes
        cost(data,params)
    return params                                      

params=np.zeros(7)
lrate=0.01
iter_value=300
params=gd(x,params,lrate,iter_value)
print(params)

plt.plot(itr,cp)
plt.show()