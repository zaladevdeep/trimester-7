import pandas as pd
import matplotlib.pyplot as plt
sales = pd.read_csv('CSI0702 Machine Learning\H\Pandas\sales_data_sample.csv', encoding='Latin-1')
sorted_sales = sales.sort_values(by=["CONTACTFIRSTNAME"], )
print(sorted_sales.head())
filterd_sales = sales[sales['CONTACTFIRSTNAME'].str.contains('Wendy')]
print(filterd_sales.head())