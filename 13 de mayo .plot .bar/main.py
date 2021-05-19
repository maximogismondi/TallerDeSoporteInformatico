import pandas as pd
import matplotlib.pyplot as plt1
import matplotlib.pyplot as plt2

csv = pd.read_csv("dataset_testeo_turismo.csv")
x1 = csv["GRUPO_ETARIO"].unique()
y1 = csv["GRUPO_ETARIO"].value_counts().tolist()
y1.reverse()

csv = csv.loc[0:300] #sino hay muchas ubicaciones y no se lee pero anda igual
x2 = csv["UBICACION"].unique()
y2 = csv["UBICACION"].value_counts().tolist()
y2.reverse()

#grafico 1
plt1.plot(x1,y1)
plt1.title('Testeados según grupo etario')
plt1.xlabel('Grupos etarios')
plt1.ylabel('Cantidad de testeados')
plt1.show()
#1. Llegamos a la conclusion de que la cantidad de testeos crece respecto a la
# edad que tengan las personas
#2. Seria conveniente saber cuantas veces se realizo el testeo a la misma persona
# para saber con exactitud el porcentaje de gente testeada segun la edad


#grafico 2
plt2.rcParams.update({'font.size': 7})
plt2.bar(x2,y2)
plt2.title('Testeados según ubicación', fontsize = 10)
plt2.xlabel('Ubicaiones', fontsize = 10)
plt2.ylabel('Cantidad de testeados', fontsize = 10)
plt2.show()