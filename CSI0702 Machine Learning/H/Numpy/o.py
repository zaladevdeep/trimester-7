import pandas as pd  
import numpy as np  
index = pd.Index([2, 1, 1, np.nan, 3])  
a = pd.Series([2, 1, 1, np.nan, 3])  
print(a)