import numpy as np
a=np.array([[1,2,3,4,5,6]])
b=np.array([[6,5,4,3,2,1]])
c=np.zeros((1,6))
for i in range(len(a)):
  c[i]=a[i]*b[i]

print(c)
