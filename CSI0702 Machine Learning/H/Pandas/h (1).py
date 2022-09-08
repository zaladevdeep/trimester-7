import pandas as pd
data = {'name': ['AA', 'IBM', 'GOOG'], 'date': ['2001-12-01', '2012-02-10', '2010-04-09'], 'shares': [100, 30, 90],
         'price': [12.3, 10.3, 32.2]}
df = pd.DataFrame(data)
df['owner'] = ['Rohan', 'Unknown', 'Unknown']
df.index = ['one', 'two', 'three']
print(df)
df = df.set_index(['name'])
print(df)
print(df['shares'])
del df['owner']
print(df)