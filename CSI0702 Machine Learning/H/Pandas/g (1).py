import pandas as pd
f = ['FB', '2001-08-02', 90, 3.2]
s = pd.Series(f, index = ['name', 'date', 'shares', 'price'])
print(s)
print(s['price'])
print(s[['name', 'date']])