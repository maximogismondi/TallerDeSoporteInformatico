import requests

archivo = open("users.csv", "a")
nombres_columnas = "nombre , apellido, email, gender, phone_number \n"
archivo.write(nombres_columnas)

for index in range(50):
    print (index)
    
    respuesta = requests.get('https://random-data-api.com/api/users/random_user')
    informacion = respuesta.json()
    linea = informacion["first_name"] + "," + informacion["last_name"] + "," + informacion["email"] + "," + informacion["gender"] + "," + informacion["phone_number"] + "\n"
    
    archivo.write(linea)
archivo.close()
