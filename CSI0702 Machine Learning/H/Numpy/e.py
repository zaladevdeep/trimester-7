import numpy as np
a=np.array([[1,1],
            [0,1]])
b=np.array([[2,0],
            [3,4]])
print(a*b,"\n")
print(a@b,"\n")
print(a.dot(b))