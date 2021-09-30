import requests
from bs4 import BeautifulSoup
import pandas as pd

if __name__ == '__main__':
    valores={}
    web = requests.get("https://www.mercadolibre.com.ar/ofertas")
    soup  = BeautifulSoup(web.content, 'html.parser')
    ofertasMLitem = soup.find_all(class_='promotion-item')
    ofertasMLnombre = soup.find_all(class_='promotion-item__title')
    ofertasMLprecio = soup.find_all(class_='promotion-item__price')
    ofertasMLdiscount = soup.find_all(class_='promotion-item__discount')
    ofertasMLlink = soup.find_all(class_='promotion-item__link-container')
    
    
    i = 0
    
    
    while i != len(ofertasMLitem):
        if "promotion-item__discount" in str(ofertasMLitem[i]):
            ofertasMLnombre[i] = ofertasMLnombre[i].get_text()
            ofertasMLdiscount[i] = ofertasMLdiscount[i].get_text()
            ofertasMLprecio[i] = ofertasMLprecio[i].get_text()
            ofertasMLlink[i] = ofertasMLlink[i].get("href")
            i+=1
        else:
            ofertasMLitem.pop(i)
            ofertasMLnombre.pop(i)
            ofertasMLprecio.pop(i)
            ofertasMLlink.pop(i)

    mapML = {'Producto': ofertasMLnombre, 'Precio Final':ofertasMLprecio, 'Descuento':ofertasMLdiscount, 'URL':ofertasMLlink}
    dfML = pd.DataFrame.from_dict(mapML)
    dfML.to_csv("descuentosML.csv")