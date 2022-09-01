from turtle import color
import pandas as pd
import matplotlib.pyplot as plt

import csv
# columns=['Date', 'Open', 'High', 'Low', 'Close', 'Adj Close', 'Volume', 'Company']
columns=['a', 'income', 'happiness']
x = pd.read_csv("CSI0702 Machine Learning\\income_data.csv", usecols=columns)
a=x.income
b=x.happiness
print(a)
print(b)
plt.title("Income vs Hapiness Data")
plt.scatter(a,b)
# plt.show()

m=0
c=0
l=0.001
epoch=1000
n=float(len(a))
for i in range(epoch):
    y_pred=m*a+c
    d_m=(-2/n) * sum(a*(b-y_pred))
    d_c=(-2/n) * sum(b-y_pred)
    m=m-l*d_m
    c=c-l*d_c

print(m,c)

plt.plot(a,m*a+c,color='red')
plt.show()