import pandas as pd
import matplotlib.pyplot as plt


sales = pd.read_csv('CSI0702 Machine Learning\H\Pandas\sales_data_sample.csv', encoding='Latin-1')
print(sales.head())
print(sales.tail())