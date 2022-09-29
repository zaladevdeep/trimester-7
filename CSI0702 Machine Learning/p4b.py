# normal eqaution with regularizatiopn

import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn import datasets,metrics


dataset = pd.read_csv('CSI0702 Machine Learning\Real_Estate_Prices.csv')
from sklearn.preprocessing import StandardScaler
sc = StandardScaler()

z=dataset.iloc[:].values
z = sc.fit_transform(z)

X = z[:, :-1]
y = z[:, -1]

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 1/3, random_state = 0)
l=np.identity(X_train.shape[1])
l[0,0]=0
lamda=1
thetas = np.dot(np.dot(np.linalg.inv(np.dot(X_train.T, X_train)+lamda*l),X_train.T),y_train)

# model evaluation for training set
y_pred = np.dot(X_train,thetas)


y_test_predict = np.dot(X_test,thetas)
rmse = (np.sqrt(metrics.mean_squared_error(y_train, y_pred)))
print(rmse)

rmse = (np.sqrt(metrics.mean_squared_error(y_test, y_test_predict)))
print(rmse)