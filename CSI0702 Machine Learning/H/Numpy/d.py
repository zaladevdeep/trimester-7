import numpy as np
from numpy import pi
import matplotlib.pyplot as plt

a=np.linspace(0,2,9)
print(a)
b=np.linspace(0,2*pi,100)
print(b)
c=np.sin(b)
plt.scatter(b,c)
plt.show()
print(c)