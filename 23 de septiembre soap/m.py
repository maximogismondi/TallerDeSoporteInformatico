import requests
from bs4 import BeautifulSoup
import pandas as pd

if __name__ == '__main__':
    valores={}
    web = requests.get("https://platinumgod.co.uk/")
    soup  = BeautifulSoup(web.content, 'html.parser')
    itemsName = soup.find_all(class_='item-title')
    itemsId = soup.find_all(class_='r-itemid')
    itemsPickUp = soup.find_all(class_='pickup')
    itemsQuality = soup.find_all(class_='quality')
    


    for i in range(len(itemsName)):
        print (itemsName[i])
        try:
            itemsName[i] = itemsName[i].get_text()
            itemsId[i] = itemsId[i].get_text()
            itemsPickUp[i] = itemsPickUp[i].get_text()
            itemsQuality[i] = itemsQuality[i].get_text()
        except:
            continue
        
    
           

    mapI = {'nombre': itemsName, 'id':itemsId, 'pick up':itemsPickUp, 'calidad':itemsQuality}
    dI = pd.DataFrame.from_dict(mapI)
    dI.to_csv("itemsIsaac.csv")