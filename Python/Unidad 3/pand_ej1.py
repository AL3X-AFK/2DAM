import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_excel("hoja.xlsx")

#print(df.describe())
#df.info()

nombres = df["Nombre"].to_list()
print(nombres)

edades = df["Edad"].to_list()
print(edades)

media1 = df["Edad"].mean()
print("La media es",media1)

df["Nota"] = df["Edad"]/2

df["Mayor"] = df["Edad"] >= 21
print(df)

'''
plt.bar(df["Nombre"], df["Edad"])
plt.title("Edad de cada alumno")
plt.xlabel("Alumno")
plt.ylabel("Edades")
plt.show()
'''

mayores = df["Mayor"].sum()
menores = len(df)-mayores

plt.pie([mayores, menores], labels=["Mayores de 21 años", "Menor de 21 años"],autopct="%1.1f%%")
plt.show()