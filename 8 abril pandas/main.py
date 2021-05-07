import pandas as pd

#1
csv = pd.read_csv("dataset_testeo_turismo.csv")

#2 - no se puede xq no hay ninguna columna que sirva como indice

#3
csv = csv.drop_duplicates()

#4
csv = csv.dropna()

#5
csv1 = csv.iloc[0:3000]
csv2 = csv.iloc[len(csv) - 2001: len(csv) - 1]
csv3 = pd.concat([csv1,csv2])

#6
csv3.to_csv("nuevo.csv")