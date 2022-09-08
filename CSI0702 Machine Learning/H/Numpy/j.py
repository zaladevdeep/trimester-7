import numpy as np
from numpy import pi
a = np.ones(3, dtype=np.int32)
b = np.linspace(0,pi,3)
print(b.dtype.name)
print(a+b)
c=np.exp((a+b)*1j)
print(c)
print(c.dtype.name)