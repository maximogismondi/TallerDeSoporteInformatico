import pandas as pd
pd.options.mode.chained_assignment = None 
import numpy as np
import matplotlib.pyplot as plt1
import matplotlib.pyplot as plt2
import matplotlib.pyplot as plt3
import matplotlib.pyplot as plt4
import matplotlib.pyplot as plt5

csv = pd.read_csv("llamados_107_covid.csv")
for i in range(len(csv["FECHA"])):
    csv["FECHA"][i] = csv["FECHA"][i][:-9]

#cual fue el mes q mas se llamo
mesesLlamados = {}
for fecha in csv["FECHA"]:
    mesesLlamados[fecha[2:]] = 0
for i in range(len(csv["COVID_LLAMADOS"])):
    mesesLlamados[csv["FECHA"][i][2:]] += csv["COVID_LLAMADOS"][i]

plt1.bar(mesesLlamados.keys(),mesesLlamados.values())
plt1.title('¿Qué mes se llamo más?')
plt1.ylabel('Llamados')
plt1.xticks(rotation=90)
plt1.show()

#mes con mas sospechosos en funcion llamados
mesesSospechosos = {}
for fecha in csv["FECHA"]:
    mesesSospechosos[fecha[2:]] = 0

for i in range(len(csv["CASOS_SOSPECHOSOS"])):
    mesesSospechosos[csv["FECHA"][i][2:]] += csv["CASOS_SOSPECHOSOS"][i]

plt2.bar(mesesSospechosos.keys(),mesesSospechosos.values())
plt2.title('¿Qué mes tuvo más sopechosos?')
plt2.ylabel('Sospechosos')
plt2.xticks(rotation=90)
plt2.show()

#porcentaje sopechosos en funcion a los llamados por mes 
mesesLlamadosSospechosos = {}
for fecha in csv["FECHA"]:
    mesesLlamadosSospechosos[fecha[2:]] = [0,0]

for i in range(len(csv["CASOS_SOSPECHOSOS"])):
    mesesLlamadosSospechosos[csv["FECHA"][i][2:]][0] += csv["CASOS_SOSPECHOSOS"][i]
    mesesLlamadosSospechosos[csv["FECHA"][i][2:]][1] += csv["COVID_LLAMADOS"][i]

mesesPorcentajeSospechosos = {}

for fecha in csv["FECHA"]:
    mesesPorcentajeSospechosos[fecha[2:]] = [0,0]

for key in mesesLlamadosSospechosos.keys():
    mesesPorcentajeSospechosos[key] = mesesLlamadosSospechosos[key][0]/mesesLlamadosSospechosos[key][1]*100

plt3.plot(mesesPorcentajeSospechosos.keys(), mesesPorcentajeSospechosos.values())
plt3.title('¿Qué mes tuvo más porcentaje de sospechosos?')
plt3.ylabel('Porcentaje')
plt3.xticks(rotation=90)
plt3.show()

#mes con mas descartados en funcion llamados

mesesLlamadosDescartados = {}
for fecha in csv["FECHA"]:
    mesesLlamadosDescartados[fecha[2:]] = [0,0]

for i in range(len(csv["CASOS_DESCARTADOS_COVID"])):
    mesesLlamadosDescartados[csv["FECHA"][i][2:]][0] += csv["CASOS_DESCARTADOS_COVID"][i]
    mesesLlamadosDescartados[csv["FECHA"][i][2:]][1] += csv["COVID_LLAMADOS"][i]

mesesPorcentajeDescartados = {}

for fecha in csv["FECHA"]:
    mesesPorcentajeDescartados[fecha[2:]] = [0,0]

for key in mesesLlamadosDescartados.keys():
    mesesPorcentajeDescartados[key] = mesesLlamadosDescartados[key][0]/mesesLlamadosDescartados[key][1]*100

plt4.plot(mesesPorcentajeDescartados.keys(),mesesPorcentajeDescartados.values())
plt4.title('¿Qué mes tuvo más porcentaje de descartados?')
plt4.ylabel('Porcentaje')
plt4.xticks(rotation=90)
plt4.show()

#mes con mas transportados + derivados en funcion llamados

mesesLlamadosTratados = {}
for fecha in csv["FECHA"]:
    mesesLlamadosTratados[fecha[2:]] = [0,0]

for i in range(len(csv["CASOS_TRASLADADOS"])):
    mesesLlamadosTratados[csv["FECHA"][i][2:]][0] += csv["CASOS_TRASLADADOS"][i] + csv["CASOS_DERIVADOS"][i]
    mesesLlamadosTratados[csv["FECHA"][i][2:]][1] += csv["COVID_LLAMADOS"][i]

mesesPorcentajeTratados = {}

for fecha in csv["FECHA"]:
    mesesPorcentajeTratados[fecha[2:]] = [0,0]

for key in mesesLlamadosDescartados.keys():
    mesesPorcentajeTratados[key] = mesesLlamadosTratados[key][0]/mesesLlamadosTratados[key][1]*100

plt5.plot(mesesPorcentajeTratados.keys(),mesesPorcentajeTratados.values())
plt5.title('¿Qué mes tuvo más porcentaje de tratados (transladados  + derivados) ?')
plt5.ylabel('Porcentaje')
plt5.xticks(rotation=90)
plt5.show()